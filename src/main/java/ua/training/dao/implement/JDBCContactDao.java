package ua.training.dao.implement;

import ua.training.dao.ContactDao;
import ua.training.model.entity.Address;
import ua.training.model.entity.Contact;

import java.sql.*;
import java.time.LocalDateTime;
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
        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
            addAddress(rs.getInt(1), entity.getAddress());
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    private void addAddress(Integer contactId, Address address) {
        String query = "INSERT INTO address (id_contact, city, street, house_number," +
                "apartment_number, postcode) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
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
    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact = null;
        String query = "SELECT * FROM contact LEFT JOIN address a ON contact.id = a.id_contact";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String middleName = rs.getString("middle_name");
                String lastName = rs.getString("last_name");
                String shortName = rs.getString("short_name");
                String login = rs.getString("login");
                String comment = rs.getString("comment");
                String homePhone = rs.getString("home_phone");
                String mobile = rs.getString("mobile");
                String email = rs.getString("email");
                String skype = rs.getString("skype");
                LocalDateTime creationDate = rs.getTimestamp("creation_date").toLocalDateTime();
                LocalDateTime modificationDate = rs.getTimestamp("modification_date").toLocalDateTime();

                contact = new Contact(id, firstName, middleName, lastName, shortName,
                        login, comment, homePhone, mobile, email, skype, getAddress(id), creationDate, modificationDate);

                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private Address getAddress(Integer contactId) {
        String query = "SELECT * FROM address WHERE id_contact = ?";
        Address address = new Address();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, contactId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String city = rs.getString("city");
                String street = rs.getString("street");
                Integer houseNumber = rs.getInt("house_number");
                Integer apartmentNumber = rs.getInt("apartment_number");
                Integer postcode = rs.getInt("postcode");

                System.out.println(postcode);
                System.out.println(city);

                address.setPostcode(postcode);
                address.setCity(city);
                address.setStreet(street);
                address.setHouseNumber(houseNumber);
                address.setApartmentNumber(apartmentNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
}
