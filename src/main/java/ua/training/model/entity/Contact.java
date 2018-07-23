package ua.training.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
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

    public String createShortName() {
        return lastName + " " + firstName.charAt(0) + ".";
    }
}
