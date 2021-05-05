package io.rahul.orders.domain.model;

import io.rahul.orders.contract.Product;
import io.rahul.orders.domain.value_objects.Address;
import io.rahul.orders.domain.value_objects.OrderStatus;
import io.rahul.orders.domain.value_objects.PhoneNumber;
import io.rahul.orders.exceptions.AmountMismatchException;
import io.rahul.orders.exceptions.NotEnoughStockException;
import io.rahul.orders.infrastructure.ProductRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configurable
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Orders")
public class Order {

    @Transient
    @Autowired
    ProductRepository productRepository;

    @Id
    private String id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Date orderDate;

    @Column(nullable = false)
    private OrderStatus status;

    @Embedded
    private Address address;

    @Embedded
    private PhoneNumber phone;

    @OneToMany(
            mappedBy = "order",
            targetEntity = OrderLine.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderLine> orderLineItems = new ArrayList<>();

    public boolean validate() throws NotEnoughStockException, AmountMismatchException {
        // TODO: Check validity of each line item
        for(OrderLine orderLine: this.orderLineItems){
            Product product = productRepository.getProductById(orderLine.getProductId());
            int remainingQuantity = product.getQuantity() - orderLine.getQuantity();
            if(remainingQuantity < 0) throw new NotEnoughStockException(this, product);

            float calculatedPrice = product.getPrice().getValue() * orderLine.getQuantity();
            if(calculatedPrice != orderLine.getAmount().getValue()) throw  new AmountMismatchException(this, product);

        }
        return true;
    }

}
