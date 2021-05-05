package io.rahul.inventory.infrastructure;

import io.rahul.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    Inventory findByProductId(String productId);

}
