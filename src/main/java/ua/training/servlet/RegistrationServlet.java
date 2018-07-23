package ua.training.servlet;

import ua.training.model.entity.Address;
import ua.training.model.entity.Contact;
import ua.training.model.entity.Model;
import ua.training.model.exception.NotUniqueFieldException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegistrationServlet extends HttpServlet {

    private static final String BUNDLE_EN = "Messages_en";
    private ResourceBundle bundle;
    private Model model;

    @Override
    public void init() {
        bundle = ResourceBundle.getBundle(BUNDLE_EN, Locale.ENGLISH);
        model = Model.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Contact contact = new Contact();
        Address address = new Address();
        contact.setFirstName(req.getParameter("firstName"));
        contact.setMiddleName(req.getParameter("middleName"));
        contact.setLastName(req.getParameter("secondName"));
        contact.setLogin(req.getParameter("login"));
        contact.setComment(req.getParameter("comment"));
        contact.setHomePhone(req.getParameter("homePhone"));
        contact.setMobile(req.getParameter("mobile"));
        contact.setEmail(req.getParameter("email"));
        contact.setSkype(req.getParameter("skype"));

        address.setPostcode(Integer.valueOf(req.getParameter("postcode")));
        address.setCity(req.getParameter("city"));
        address.setStreet(req.getParameter("street"));
        address.setHouseNumber(Integer.valueOf(req.getParameter("houseNumber")));
        address.setApartmentNumber(Integer.valueOf(req.getParameter("apartmentNumber")));
        contact.setAddress(address);

        validateUserInput(req, contact);
        checkInputForUnique(resp, contact);

        req.setAttribute("contact", contact.getShortName());
        RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
        dispatcher.include(req, resp);
    }

    private void validateUserInput(HttpServletRequest req, Contact contact) {
        List<String> errors = Utility.verifyUserInput(contact, bundle);
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
        }
    }

    private void checkInputForUnique(HttpServletResponse resp, Contact contact) throws IOException {
        try {
            Utility.checkUniquenessInput(model, contact);
            model.addContact(contact);
        } catch (NotUniqueFieldException e) {
            PrintWriter out= resp.getWriter();
            out.println("<font color=red>"+ e.getMessage() + "</font>");
        }
    }
}
