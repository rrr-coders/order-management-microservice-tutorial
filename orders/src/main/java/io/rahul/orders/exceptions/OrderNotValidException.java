package io.rahul.orders.exceptions;

import io.rahul.orders.contract.OrderCreateRequest;

public class OrderNotValidException extends RuntimeException {

    public OrderNotValidException(String message) {
        super(message);
    }

}
