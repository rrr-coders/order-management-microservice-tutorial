package io.rahul.product.domain.value_objects;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
@Setter
@Builder
public class Money {
    @NotNull(message = "value is required")
    @Positive(message = "value must be greater that 0")
    private float value;
    @NotNull(message = "currency is required")
    private Currency currency;
}
