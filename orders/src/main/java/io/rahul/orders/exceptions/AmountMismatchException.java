package io.rahul.orders.exceptions;

import io.rahul.orders.contract.Product;
import io.rahul.orders.domain.model.Order;
import lombok.Getter;

import java.util.HashMap;

public class AmountMismatchException extends OrderNotValidException{

    @Getter
    private final String details;

    public AmountMismatchException(Order order, Product product) {
        super("Amount mismatch exception");
        this.details = this.mapException(order, product);
    }

    private String mapException(Order order, Product product){
        HashMap<String, Object> map = new HashMap<>();
        map.put("order", order);
        map.put("product", product);
        return map.toString();
    }
}
