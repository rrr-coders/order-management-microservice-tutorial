package io.rahul.inventory.application;

import io.rahul.inventory.domain.Product;

import java.util.List;

public interface IProductService {

    Product save(Product product);

    List<Product> getProducts();

    Product getProductById(String id);

    Product update(Product product);

}
