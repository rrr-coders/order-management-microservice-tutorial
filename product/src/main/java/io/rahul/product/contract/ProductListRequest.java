package io.rahul.product.contract;

import io.rahul.product.domain.value_objects.Money;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductListRequest {

    private String id;
    private String name;
    private String code;
    private Money price;
    private int quantity;

}
