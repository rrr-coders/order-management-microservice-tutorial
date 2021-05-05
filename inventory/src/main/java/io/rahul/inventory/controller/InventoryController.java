package io.rahul.inventory.controller;

import io.rahul.inventory.contracts.InventoryDTO;
import io.rahul.inventory.contracts.InventoryUpdate;
import io.rahul.inventory.domain.Inventory;
import io.rahul.inventory.exceptions.NegativeQuantityException;
import io.rahul.inventory.application.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/products/{id}")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ModelMapper modelMapper;

    @PutMapping("products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryDTO update(@Valid @RequestBody InventoryUpdate update, @PathVariable String productId) throws NegativeQuantityException {
        Inventory inventory = inventoryService.updateQuantity(productId, update);
        return this.convertToDto(inventory);
    }

    private InventoryDTO convertToDto(Inventory inventory) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        InventoryDTO inventoryDTO = modelMapper.map(inventory, InventoryDTO.class);
        inventoryDTO.setProductName(inventory.getProduct().getName());
        return inventoryDTO;
    }


}
