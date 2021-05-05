package io.rahul.orders.contract;

import io.rahul.orders.domain.value_objects.Address;
import io.rahul.orders.domain.value_objects.PhoneNumber;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
public class OrderCreateRequest {

    @NotNull(message = "userId is required")
    private final String userId;

    @Valid
    @NotNull(message = "Address is required")
    private final Address address;

    @NotNull(message = "PhoneNumber is required")
    @Valid
    private final PhoneNumber phoneNumber;

    @Valid
    @NotNull(message = "orderLineItems is required")
    @Size(min = 1, max = 5, message = "Minimum 1 line item or maximum 5 line items")
    private final List<OrderLineCreateRequest> orderLineItems;

}


