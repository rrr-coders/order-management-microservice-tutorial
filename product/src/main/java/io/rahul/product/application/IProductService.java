package io.rahul.product.application;

import io.rahul.product.contract.ProductCreateRequest;
import io.rahul.product.contract.ProductDecreaseRequest;
import io.rahul.product.domain.model.Product;
import io.rahul.product.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product create(ProductCreateRequest productCreateRequest);

    Product decreaseQuantity(String id, ProductDecreaseRequest quantity);

    Product getProductById(String id) throws ProductNotFoundException;

    List<Product> getProducts();

}
