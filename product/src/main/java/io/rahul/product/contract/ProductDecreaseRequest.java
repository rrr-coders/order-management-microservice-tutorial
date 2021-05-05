package io.rahul.product.contract;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ProductDecreaseRequest {

    @Min(value = 1, message = "quantity must be at least 1")
    private int quantity;

}
