package com.xproject.order.repository;

import com.xproject.order.OrderApplicationTests;
import com.xproject.order.dataobject.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("542423");
        orderDetail.setOrderId("4324324");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("122321241423123");
        orderDetail.setProductName("猪肝瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal(7));
        orderDetail.setProductQuantity(2);
        orderDetail.setCreateTime(LocalDateTime.now());
        orderDetail.setUpdateTime(LocalDateTime.now());

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.isTrue(result != null);
    }

}