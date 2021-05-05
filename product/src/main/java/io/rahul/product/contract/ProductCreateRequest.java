package io.rahul.product.contract;

import io.rahul.product.domain.value_objects.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
public class ProductCreateRequest {

    @NotEmpty(message = "name is required")
    @Size(max = 240, message = "name cannot exceed 240 characters")
    private String name;

    @NotEmpty(message = "code is required")
    @Size(max = 30, message = "code cannot exceed 30 characters")
    private String code;

    @NotNull(message = "price is required")
    @Valid
    private Money price;

    @NotNull
    @Min(value = 1, message = "quantity must be at least 1")
    private int quantity;

}
