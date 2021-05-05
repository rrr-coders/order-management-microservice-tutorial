package io.rahul.inventory.application;

import io.rahul.inventory.dao.InventoryDAO;
import io.rahul.inventory.dao.ProductDAO;
import io.rahul.inventory.domain.Inventory;
import io.rahul.inventory.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    InventoryDAO inventoryDAO;


    @Override
    @Transactional
    public Product save(Product product) {

        String productId = UUID.randomUUID().toString();

        Inventory inventory = Inventory.builder()
                .Id(UUID.randomUUID().toString())
                .productId(productId)
                .quantity(1).build();

        Product newProduct = Product.builder()
                .id(productId)
                .sellerId(product.getSellerId())
                .name(product.getName())
                .code(product.getCode())
                .inventory(inventory).build();

        newProduct = productDAO.save(newProduct);


//        inventoryDAO.save(inventory);

        return newProduct;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = productDAO.findAll();
        return products;
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
