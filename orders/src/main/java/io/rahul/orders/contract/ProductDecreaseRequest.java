package io.rahul.orders.contract;

import lombok.*;

import javax.validation.constraints.Min;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDecreaseRequest {

    private int quantity;

}
