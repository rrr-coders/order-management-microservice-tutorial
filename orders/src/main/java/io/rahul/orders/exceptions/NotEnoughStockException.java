package io.rahul.orders.exceptions;

import io.rahul.orders.contract.OrderCreateRequest;
import io.rahul.orders.contract.Product;
import io.rahul.orders.domain.model.Order;
import lombok.Getter;

import java.util.HashMap;

public class NotEnoughStockException extends  OrderNotValidException {

    @Getter
    private final String details;

    public NotEnoughStockException(Order order, Product product) {
        super("Not Enough Stock Exception");
        this.details = this.mapException(order, product);
    }

    private String mapException(Order order, Product product){
        HashMap<String, Object> map = new HashMap<>();
        map.put("order", order);
        map.put("product", product);
        return map.toString();
    }

}
