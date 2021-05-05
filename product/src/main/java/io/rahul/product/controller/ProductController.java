package io.rahul.product.controller;

import io.rahul.product.application.IProductService;
import io.rahul.product.contract.ProductCreateRequest;
import io.rahul.product.contract.ProductDecreaseRequest;
import io.rahul.product.contract.ProductListRequest;
import io.rahul.product.domain.model.Product;
import io.rahul.product.exceptions.ProductNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product-ms/api/v1/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductListRequest> create(@Valid @RequestBody ProductCreateRequest request){
        Product product = productService.create(request);
        ProductListRequest productListRequest = this.convertToProductListRequest(product);
        return new ResponseEntity<>(productListRequest, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<ProductListRequest> getProducts(){
        List<Product> products = this.productService.getProducts();
        return products.stream()
                .map(this::convertToProductListRequest).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductListRequest getProducts(@PathVariable String id){
        Product product = this.productService.getProductById(id);
        return this.convertToProductListRequest(product);
    }

    @PutMapping("/{id}/quantity/decrease")
    public Product decreaseProducts(@PathVariable String id, @RequestBody ProductDecreaseRequest quantity){
        return this.productService.decreaseQuantity(id, quantity);
    }

    private ProductListRequest convertToProductListRequest(Product product){
        return this.modelMapper.map(product, ProductListRequest.class);
    }

}
