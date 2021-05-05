package io.rahul.orders.contract;

import io.rahul.orders.domain.value_objects.Money;
import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private String code;
    private int quantity;
    private Money price;

}