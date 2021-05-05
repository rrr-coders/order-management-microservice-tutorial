package io.rahul.inventory.contracts;

import lombok.Data;

@Data
public class InventoryDTO {

    private String Id;

    private String productId;

    private String productName;

    private int quantity;

}
