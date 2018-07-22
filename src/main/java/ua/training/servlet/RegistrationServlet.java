package ua.training.servlet;

import ua.training.model.entity.Contact;
import ua.training.model.entity.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Model model = Model.getInstance();
        //forward main page
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
        rd.include(request, response);

        model.addContact(new Contact(firstName, secondName, login, password));
    }
}
