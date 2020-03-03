package com.xproject.order.controller;

import com.xproject.order.client.ProductClient;
import com.xproject.order.dataobject.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    //第二种方式
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    //第三种方式
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //1.第一种方式(直接使用restTemplate)
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);
//        System.out.println("response={"+response+"}");
//        return response;

        //2.第二种方法(利用loadBalancerClient通过应用名获取url，然后再使用restTemplate)
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
//        String response = restTemplate.getForObject(url,String.class);
//        System.out.println("response={"+response+"}");
//        return response;

        //3.第三种方式(利用@LoadBalanced，可在restTemplate里使用应用名字)
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        System.out.println("response={"+response+"}");
        return response;

//        String response = productClient.productMsg();
//        System.out.println("response={"+response+"}");
//        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("164103465734242707"));
        System.out.println("response={"+productInfoList+"}");
        return "successful";
    }
}
