package ua.training.service;

import ua.training.dao.ContactDao;
import ua.training.dao.DaoFactory;
import ua.training.model.entity.Contact;

import java.sql.SQLException;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactDao contactDao = DaoFactory.getInstance().createContactDao();

    @Override
    public Integer create(Contact contact) throws SQLException {
        return contactDao.create(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }
}
