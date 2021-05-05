package io.rahul.inventory.contracts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private String id;

    private String name;

    private String code;

    private String sellerId;

    private int quantity;
}
