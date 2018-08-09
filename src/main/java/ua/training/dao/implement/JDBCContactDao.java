package ua.training.dao.implement;

import ua.training.dao.ContactDao;
import ua.training.model.entity.Address;
import ua.training.model.entity.Contact;
import ua.training.model.exception.NotUniqueFieldException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCContactDao implements ContactDao {
    private Connection connection;

    public JDBCContactDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Integer create(Contact entity) throws SQLException {
        String query = "INSERT INTO contact (first_name, middle_name, last_name," +
                "short_name, login, comment, home_phone, mobile, email, skype, " +
                "creation_date, modification_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getMiddleName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getShortName());
            ps.setString(5, entity.getLogin());
            ps.setString(6, entity.getComment());
            ps.setString(7, entity.getHomePhone());
            ps.setString(8, entity.getMobile());
            ps.setString(9, entity.getEmail());
            ps.setString(10, entity.getSkype());
            ps.setTimestamp(11, Timestamp.valueOf(entity.getCreationDate()));
            ps.setTimestamp(12, Timestamp.valueOf(entity.getModificationDate()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            createAddressByContactId(rs.getInt(1), entity.getAddress());
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    private void createAddressByContactId(Integer contactId, Address address) {
        String query = "INSERT INTO address (id_contact, city, street, house_number," +
                "apartment_number, postcode) VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, contactId);
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setInt(4, address.getHouseNumber());
            ps.setInt(5, address.getApartmentNumber());
            ps.setInt(6, address.getPostcode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contact findById(int id) {
        return null;
    }

    @Override
    public List<Contact> findAll() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();
        String query = "SELECT * FROM contact LEFT JOIN address a ON contact.id = a.id_contact";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contact.setId(rs.getInt("id"));
                contact.setFirstName(rs.getString("first_name"));
                contact.setMiddleName(rs.getString("middle_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setShortName(rs.getString("short_name"));
                contact.setLogin(rs.getString("login"));
                contact.setComment(rs.getString("comment"));
                contact.setHomePhone(rs.getString("home_phone"));
                contact.setMobile(rs.getString("mobile"));
                contact.setEmail(rs.getString("email"));
                contact.setSkype(rs.getString("skype"));
                contact.setCreationDate(rs.getTimestamp("creation_date").toLocalDateTime());
                contact.setModificationDate(rs.getTimestamp("modification_date").toLocalDateTime());
                contact.setAddress(findAddressByContactId(rs.getInt("id")));

                contacts.add(contact);
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return contacts;
    }

    private Address findAddressByContactId(Integer contactId) throws SQLException {
        String query = "SELECT * FROM address WHERE id_contact = ?";
        Address address = new Address();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, contactId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setHouseNumber(rs.getInt("house_number"));
                address.setApartmentNumber(rs.getInt("apartment_number"));
                address.setPostcode(rs.getInt("postcode"));
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return address;
    }

    @Override
    public void update(Contact entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void checkLogin(String login) throws NotUniqueFieldException {
        String query = "SELECT true FROM contact WHERE login = ? LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new NotUniqueFieldException("Contact with such login already exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void checkMobile(String mobile) throws NotUniqueFieldException {
        String query = "SELECT true FROM contact WHERE mobile = ? LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, mobile);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new NotUniqueFieldException("Contact with such mobile already exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkSkype(String skype) throws NotUniqueFieldException {
        String query = "SELECT true FROM contact WHERE skype = ? LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, skype);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new NotUniqueFieldException("Contact with such skype already exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkEmail(String email) throws NotUniqueFieldException {
        String query = "SELECT true FROM contact WHERE email = ? LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new NotUniqueFieldException("Contact with such email already exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
