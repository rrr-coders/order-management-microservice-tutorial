package io.rahul.orders.infrastructure;

import io.rahul.orders.domain.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, String> {
}
