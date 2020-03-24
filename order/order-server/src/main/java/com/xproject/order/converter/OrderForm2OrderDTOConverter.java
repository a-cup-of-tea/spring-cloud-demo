package com.xproject.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xproject.order.OrderException;
import com.xproject.order.dataobject.OrderDetail;
import com.xproject.order.dto.OrderDTO;
import com.xproject.order.enums.ResultEnum;
import com.xproject.order.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList=gson.fromJson(orderForm.getItem(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            //TODO 引入日志
//            log.error("【json转换】错误，String={}",orderForm.getItem());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
