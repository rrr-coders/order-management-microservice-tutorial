package io.rahul.orders.contract;

import io.rahul.orders.domain.value_objects.Money;
import io.rahul.orders.domain.value_objects.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineResponse {

    private String id;
    private String productId;
    private int quantity;
    private Money amount;
    private OrderStatus status;

}
