package io.rahul.orders.domain.value_objects;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class PhoneNumber {

    @NotNull(message = "Country code is required")
    private CountryCode countryCode;

    @NotNull(message = "Phone number is required")
    private String phoneNumber;

}
