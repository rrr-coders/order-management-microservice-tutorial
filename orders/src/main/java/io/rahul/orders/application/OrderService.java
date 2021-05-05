package io.rahul.orders.application;

import io.rahul.orders.contract.OrderCreateRequest;
import io.rahul.orders.contract.ProductDecreaseRequest;
import io.rahul.orders.domain.model.Order;
import io.rahul.orders.domain.model.OrderLine;
import io.rahul.orders.domain.value_objects.OrderStatus;
import io.rahul.orders.exceptions.NotEnoughStockException;
import io.rahul.orders.exceptions.OrderNotValidException;
import io.rahul.orders.infrastructure.OrderRepository;
import io.rahul.orders.infrastructure.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Order create(OrderCreateRequest orderRequest) throws OrderNotValidException {
        try {

            final Order newOrder = Order.builder()
                    .id(UUID.randomUUID().toString())
                    .userId(orderRequest.getUserId())
                    .address(orderRequest.getAddress())
                    .phone(orderRequest.getPhoneNumber())
                    .status(OrderStatus.PLACED)
                    .orderDate(new Date())
                    .productRepository(productRepository)
                    .build();

            List<OrderLine> orderLineItems = orderRequest.getOrderLineItems().stream()
                    .map(lineItem -> OrderLine.builder()
                            .id(UUID.randomUUID().toString())
                            .productId(lineItem.getProductId())
                            .quantity(lineItem.getQuantity())
                            .status(OrderStatus.PLACED)
                            .amount(lineItem.getAmount())
                            .order(newOrder)
                            .build()).collect(Collectors.toList());

            newOrder.setOrderLineItems(orderLineItems);
            newOrder.validate();
            orderRepository.save(newOrder);

            for(OrderLine lineItem: newOrder.getOrderLineItems()){
                productRepository.updateProductQuantity(lineItem.getProductId(),
                        ProductDecreaseRequest
                                .builder()
                                .quantity(lineItem.getQuantity())
                                .build());
            }

            return newOrder;


        } catch (NotEnoughStockException e) {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public String getGreeting() {
        return productRepository.getGreeting();
    }
}
