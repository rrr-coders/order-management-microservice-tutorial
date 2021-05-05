package io.rahul.inventory.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.rahul.inventory.contracts.InventoryUpdate;
import io.rahul.inventory.exceptions.NegativeQuantityException;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    private String Id;

    @NotEmpty(message = "productId is required")
    private String productId;

    @Min(value = 0, message = "Quantity must be at least 0")
    private int quantity;

    @OneToOne(mappedBy = "inventory")
    @JsonIgnore
    private Product product;

    public void updateQuantity(InventoryUpdate update) throws NegativeQuantityException {
        switch (update.getAction()) {
            case ADD:
                this.quantity += update.getQuantity();
                break;

            case REDUCE:
                if (this.quantity - update.getQuantity() < 0) {
                    throw new NegativeQuantityException();
                }
                this.quantity -= quantity;
                break;

        }
    }


}
