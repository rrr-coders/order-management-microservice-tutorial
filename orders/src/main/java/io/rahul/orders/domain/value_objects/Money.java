package io.rahul.orders.domain.value_objects;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Money {
    @NotNull(message = "code is required")
    private Currency currency;
    @NotNull(message = "value is required")
    @Min(value = 1, message = "value must be atleast 1")
    private float value;
}
