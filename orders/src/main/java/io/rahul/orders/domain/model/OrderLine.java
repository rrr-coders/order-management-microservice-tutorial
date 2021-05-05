package io.rahul.orders.domain.model;

import io.rahul.orders.domain.value_objects.Money;
import io.rahul.orders.domain.value_objects.OrderStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Order_Lines")
public class OrderLine {

    @Id
    private String id;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Money amount;

    @Column(nullable = false)
    private OrderStatus status;

    @ManyToOne()
    @JoinColumn(name = "order_id", nullable = false, insertable = true)
    private Order order;

    public void setOrder(Order order){
        this.order = order;
        if(!order.getOrderLineItems().contains(this)){
            order.getOrderLineItems().add(this);
        }
    }

}
