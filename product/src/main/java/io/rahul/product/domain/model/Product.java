package io.rahul.product.domain.model;

import io.rahul.product.domain.value_objects.Money;
import io.rahul.product.exceptions.NegativeQuantityException;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Embedded
    private Money price;

    @Column(nullable = false)
    private int quantity;

    private void setQuantity(int quantity){
        this.quantity = quantity;
    }


    public boolean hasRequiredStock(int quantity){
        return this.getQuantity() - quantity >= 0;
    }

    public void decreaseStock(int quantity) throws  NegativeQuantityException{
        if(this.getQuantity() - quantity < 0){
            throw new NegativeQuantityException();
        }
        int updatedQuantity = this.getQuantity() - quantity;
        this.setQuantity(updatedQuantity);
    }

    public void increaseStock(int quantity){
        this.setQuantity(this.getQuantity() + quantity);
    }

}
