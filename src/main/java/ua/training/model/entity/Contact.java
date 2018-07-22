package ua.training.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
class Contact {
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String shortName;
    private String login;
    private String comment;
    private String homePhone;
    private String mobile;
    private String email;
    private String skype;
    private Address address;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}