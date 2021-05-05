package io.rahul.orders.contract;

import io.rahul.orders.domain.value_objects.Money;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class OrderLineCreateRequest {
    @NotNull(message = "productId is required")
    private final String productId;

    @NotNull(message = "quantity is required")
    @Min(value = 1, message = "quantity must be at least 1")
    private final int quantity;

    @NotNull(message = "amount is required")
    @Valid
    private final Money amount;
}
