package ua.training.model.entity;

import ua.training.model.exception.NotUniqueFieldException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    private static int COUNT = 0;

    private static Model instance = new Model();

    private List<Contact> contacts;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contact.setId(++COUNT);
        contact.setShortName(contact.createShortName());
        contact.setCreationDate(LocalDateTime.now());
        contact.setModificationDate(LocalDateTime.now());
        contacts.add(contact);
    }

    public List<String> getContacts() {
        return contacts.stream()
                    .map(Contact::toString)
                    .collect(Collectors.toList());
    }

    public void checkLogin(String inputLogin) throws NotUniqueFieldException {
        boolean isUnique = contacts.stream()
                    .map(Contact::getLogin)
                    .anyMatch(login -> login.equals(inputLogin));
        if (isUnique) {
            throw new NotUniqueFieldException("Contact with such login already exists");
        }
    }

    public void checkMobile(String inputMobile) throws NotUniqueFieldException {
        boolean isUnique = contacts.stream()
                .map(Contact::getMobile)
                .anyMatch(mobile -> mobile.equals(inputMobile));
        if (isUnique) {
            throw new NotUniqueFieldException("Contact with such mobile already exists");
        }
    }

    public void checkSkype(String inputSkype) throws NotUniqueFieldException {
        boolean isUnique = contacts.stream()
                .map(Contact::getSkype)
                .anyMatch(skype -> skype.equals(inputSkype));
        if (isUnique) {
            throw new NotUniqueFieldException("Contact with such skype already exists");
        }
    }

    public void checkEmail(String inputEmail) throws NotUniqueFieldException {
        boolean isUnique = contacts.stream()
                .map(Contact::getEmail)
                .anyMatch(email -> email.equals(inputEmail));
        if (isUnique) {
            throw new NotUniqueFieldException("Contact with such email already exists");
        }
    }
}
