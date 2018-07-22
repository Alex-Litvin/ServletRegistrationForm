package ua.training.model.entity;

import lombok.Data;

@Data
class Address {
    private Integer postcode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
}
