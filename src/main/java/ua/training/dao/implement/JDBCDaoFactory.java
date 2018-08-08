package ua.training.dao.implement;

import ua.training.dao.ContactDao;
import ua.training.dao.DaoFactory;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dateSource;

    public JDBCDaoFactory() {
        try {
            InitialContext ic = new InitialContext();
            dateSource = (DataSource) ic.lookup( "java:comp/env/jdbc/contact_db");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection(){
        try {
            return dateSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ContactDao createContactDao() {
        return new JDBCContactDao(getConnection());
    }
}
