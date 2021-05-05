package io.rahul.inventory.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InventoryUpdate {

    private final int quantity;
    private final InventoryAction action;

}
