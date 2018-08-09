package ua.training.service;

import ua.training.dao.ContactDao;
import ua.training.dao.DaoFactory;
import ua.training.model.entity.Contact;
import ua.training.model.exception.NotUniqueFieldException;

import java.sql.SQLException;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactDao contactDao = DaoFactory.getInstance().createContactDao();

    @Override
    public Integer create(Contact contact) throws SQLException {
        return contactDao.create(contact);
    }

    @Override
    public List<Contact> findAll() throws SQLException {
        return contactDao.findAll();
    }

    @Override
    public void checkLogin(String login) throws NotUniqueFieldException {
        contactDao.checkLogin(login);
    }

    @Override
    public void checkMobile(String mobile) throws NotUniqueFieldException {
        contactDao.checkMobile(mobile);
    }

    @Override
    public void checkSkype(String skype) throws NotUniqueFieldException {
        contactDao.checkSkype(skype);
    }

    @Override
    public void checkEmail(String email) throws NotUniqueFieldException {
        contactDao.checkEmail(email);
    }
}
