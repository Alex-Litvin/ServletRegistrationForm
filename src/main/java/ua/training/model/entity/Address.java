package ua.training.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Integer postcode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
}
