package io.rahul.orders.infrastructure;

import io.rahul.orders.contract.Product;
import io.rahul.orders.contract.ProductDecreaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="products")
public interface ProductRepository {

    @GetMapping("/product-ms/products/{productId}")
    Product getProductById(@PathVariable String productId);

    @PutMapping("/product-ms/products/{productId}/quantity/decrease")
    Product updateProductQuantity(@PathVariable String productId, @RequestBody ProductDecreaseRequest productDecreaseRequest);

    @GetMapping("/product-ms/greetings/")
    String getGreeting();


}
