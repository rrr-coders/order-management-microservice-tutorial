package io.rahul.orders.domain.value_objects;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotNull(message = "building name is required")
    private String building;
    @NotNull(message = "street name is required")
    private String street;
    @NotNull(message = "city name is required")
    private String city;
    @NotNull(message = "state name is required")
    private String state;
    @NotNull(message = "country name is required")
    private String country;
    @NotNull(message = "pincode name is required")
    private String pincode;

}
