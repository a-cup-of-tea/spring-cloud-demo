package com.xproject.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("product")
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();
}
