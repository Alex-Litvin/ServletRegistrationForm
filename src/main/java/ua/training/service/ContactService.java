package ua.training.service;

import ua.training.model.entity.Contact;
import ua.training.model.exception.NotUniqueFieldException;

import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    Integer create(Contact contact) throws SQLException;
    List<Contact> findAll() throws SQLException;
    void checkLogin(String login) throws NotUniqueFieldException;
    void checkMobile(String mobile) throws NotUniqueFieldException;
    void checkSkype(String skype) throws NotUniqueFieldException;
    void checkEmail(String email) throws NotUniqueFieldException;
}
