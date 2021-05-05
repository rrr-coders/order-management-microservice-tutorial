package io.rahul.orders.infrastructure;

import io.rahul.orders.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
