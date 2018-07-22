package ua.training.model.entity;

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
        contacts.add(contact);
    }

    public List<String> getContacts() {
        return contacts.stream()
                    .map(Contact::getFirstName)
                    .collect(Collectors.toList());
        }
}
