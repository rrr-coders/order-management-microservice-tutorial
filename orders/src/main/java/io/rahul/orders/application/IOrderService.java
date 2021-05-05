package io.rahul.orders.application;

import io.rahul.orders.contract.OrderCreateRequest;
import io.rahul.orders.domain.model.Order;

import java.util.List;

public interface IOrderService {

    Order create(OrderCreateRequest order);

    List<Order> findAll();

    String getGreeting();

}
