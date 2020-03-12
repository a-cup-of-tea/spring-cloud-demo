package com.xproject.order.service.impl;

import com.xproject.order.client.ProductClient;
import com.xproject.order.dataobject.OrderDetail;
import com.xproject.order.dataobject.OrderMaster;
import com.xproject.order.dataobject.ProductInfo;
import com.xproject.order.dto.CartDTO;
import com.xproject.order.dto.OrderDTO;
import com.xproject.order.enums.OrderStatusEnum;
import com.xproject.order.enums.PayStatusEnum;
import com.xproject.order.repository.OrderDetailRepository;
import com.xproject.order.repository.OrderMasterRepository;
import com.xproject.order.service.OrderService;
import com.xproject.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.genUniqueKey();
        //查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);

        if(productIdList==null||productIdList.isEmpty()){
            //TODO 校验productInfoList是否空,异常定义
        }

        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    //单价*数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtils.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        //扣库存（调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.deceaseStock(cartDTOList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtils.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(LocalDateTime.now());
        orderMaster.setUpdateTime(LocalDateTime.now());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
