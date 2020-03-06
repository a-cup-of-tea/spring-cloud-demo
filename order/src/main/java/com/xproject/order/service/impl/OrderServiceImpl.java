package com.xproject.order.service.impl;

import com.xproject.order.dataobject.OrderMaster;
import com.xproject.order.dto.OrderDTO;
import com.xproject.order.enums.OrderStatusEnum;
import com.xproject.order.enums.PayStatusEnum;
import com.xproject.order.repository.OrderDetailRepository;
import com.xproject.order.repository.OrderMasterRepository;
import com.xproject.order.service.OrderService;
import com.xproject.order.utils.keyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO 查询商品信息（调用商品服务）
        //TODO 计算总价
        //TODO 扣库存（调用商品服务）

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(keyUtils.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());


        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
