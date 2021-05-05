package io.rahul.inventory.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @JsonIgnore
    private String id;

    @NotEmpty
    private String sellerId;

    @NotEmpty
    @Size(min = 5, max = 240)
    private String name;

    @NotEmpty
    private String code;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventoryId")
    private Inventory inventory;

}
