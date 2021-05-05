package io.rahul.inventory.application;

import io.rahul.inventory.contracts.InventoryUpdate;
import io.rahul.inventory.domain.Inventory;
import io.rahul.inventory.exceptions.NegativeQuantityException;

import java.util.List;

public interface IInventoryService {

    Inventory updateQuantity(String productId, InventoryUpdate update) throws NegativeQuantityException;

    List<Inventory> findAll();

}
