package io.rahul.orders.controller;

import io.rahul.orders.application.IOrderService;
import io.rahul.orders.contract.OrderCreateRequest;
import io.rahul.orders.contract.OrderLineResponse;
import io.rahul.orders.contract.OrderResponse;
import io.rahul.orders.domain.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order-ms/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/")
    List<OrderResponse> getOrders(){
        List<Order> orders = orderService.findAll();
        List<OrderResponse> orderResponses = orders.stream()
                .map(this::convertToOrderResponse).collect(Collectors.toList());
        System.out.println(orderResponses);
        return orderResponses;
    }

    @PostMapping("/")
    OrderResponse save(@Valid @RequestBody OrderCreateRequest orderCreateRequest){
        return this.convertToOrderResponse(orderService.create(orderCreateRequest));
    }



    private OrderResponse convertToOrderResponse(Order order){
        OrderResponse response = this.modelMapper.map(order, OrderResponse.class);
        List<OrderLineResponse> lines = order.getOrderLineItems().stream()
                .map(line -> this.modelMapper.map(line, OrderLineResponse.class)).collect(Collectors.toList());
        response.setOrderLineItems(lines);
        return response;
    }

}
