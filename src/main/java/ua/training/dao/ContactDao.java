package ua.training.dao;


import ua.training.model.entity.Contact;
import ua.training.model.exception.NotUniqueFieldException;

public interface ContactDao extends GenericDao<Contact> {
    void checkLogin(String login) throws NotUniqueFieldException;
    void checkMobile(String mobile) throws NotUniqueFieldException;
    void checkSkype(String skype) throws NotUniqueFieldException;
    void checkEmail(String email) throws NotUniqueFieldException;
}
