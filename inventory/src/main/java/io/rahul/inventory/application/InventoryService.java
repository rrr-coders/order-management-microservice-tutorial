package io.rahul.inventory.application;

import io.rahul.inventory.dao.InventoryDAO;
import io.rahul.inventory.contracts.InventoryUpdate;
import io.rahul.inventory.domain.Inventory;
import io.rahul.inventory.exceptions.NegativeQuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {

    @Autowired
    InventoryDAO inventoryDAO;

    @Override
    public Inventory updateQuantity(String productId, InventoryUpdate update) throws NegativeQuantityException {
        Inventory inventory = inventoryDAO.findByProductId(productId);
        inventory.updateQuantity(update);
        inventory = inventoryDAO.save(inventory);
        return inventory;
    }

    @Override
    public List<Inventory> findAll() {
        List<Inventory> inventories = inventoryDAO.findAll();
        return inventories;
    }
}
