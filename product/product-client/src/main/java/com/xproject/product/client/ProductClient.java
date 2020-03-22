package com.xproject.product.client;

import com.xproject.product.common.DecreaseStockInput;
import com.xproject.product.common.ProductInfoOutput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductClient {
    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/deceaseStock")
    public void deceaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);
}
