package io.rahul.product.application;

import io.rahul.product.contract.ProductCreateRequest;
import io.rahul.product.contract.ProductDecreaseRequest;
import io.rahul.product.domain.model.Product;
import io.rahul.product.exceptions.ProductNotFoundException;
import io.rahul.product.infrastructure.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(ProductCreateRequest productCreateRequest) {
        Product product = Product.builder()
                .id(UUID.randomUUID().toString())
                .name(productCreateRequest.getName())
                .code(productCreateRequest.getCode())
                .quantity(productCreateRequest.getQuantity())
                .price(productCreateRequest.getPrice()).build();

        return productRepository.save(product);
    }

    @Override
    public Product decreaseQuantity(String id, ProductDecreaseRequest request) {
        Optional<Product> optionalProduct = this.productRepository.findById(id);
        if(optionalProduct.isEmpty()) throw new ProductNotFoundException(id);
        Product product = optionalProduct.get();
        product.decreaseStock(request.getQuantity());
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(String id) throws ProductNotFoundException {
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isEmpty()) throw new ProductNotFoundException(id);
        return product.get();
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }



}
