package com.xproject.order.client;

import com.xproject.order.dataobject.ProductInfo;
import com.xproject.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("product")
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody  List<String> productIdList);

    @PostMapping("/product/deceaseStock")
    public void deceaseStock(@RequestBody List<CartDTO> cartDTOList);
}
