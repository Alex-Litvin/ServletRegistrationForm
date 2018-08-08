package ua.training.service;

import ua.training.model.entity.Contact;

import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    Integer create(Contact contact) throws SQLException;
    List<Contact> findAll();
}
