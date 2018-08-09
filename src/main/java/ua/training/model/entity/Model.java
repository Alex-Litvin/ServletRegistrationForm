package ua.training.model.entity;

import ua.training.service.ContactService;
import ua.training.service.ContactServiceImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance = new Model();

    private ContactService contactService;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        contactService = new ContactServiceImpl();
    }

    public void addContact(Contact contact) throws SQLException {
        contact.setShortName(contact.createShortName());
        contact.setCreationDate(LocalDateTime.now());
        contact.setModificationDate(LocalDateTime.now());
        contactService.create(contact);
    }

    public List<Contact> getContacts() throws SQLException {
        return new ArrayList<>(contactService.findAll());
    }
}
