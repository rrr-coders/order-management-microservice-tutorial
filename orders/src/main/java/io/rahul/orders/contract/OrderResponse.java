package io.rahul.orders.contract;

import io.rahul.orders.domain.model.OrderLine;
import io.rahul.orders.domain.value_objects.Address;
import io.rahul.orders.domain.value_objects.OrderStatus;
import io.rahul.orders.domain.value_objects.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private String id;
    private String userId;
    private Date orderDate;
    private OrderStatus status;
    private Address address;
    private PhoneNumber phone;
    private List<OrderLineResponse> orderLineItems;

}
