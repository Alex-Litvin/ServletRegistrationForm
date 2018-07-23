package ua.training.servlet;

import ua.training.model.ContactConstants;
import ua.training.model.entity.Contact;
import ua.training.model.entity.Model;
import ua.training.model.exception.NotUniqueFieldException;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

class Utility implements ContactConstants, VerificationConstants {

    static List<String> verifyUserInput(Contact contact, ResourceBundle bundle) throws NumberFormatException {
        List<String> errors = new ArrayList<>();

        verifyName(errors, contact.getFirstName(), bundle.getString(NAME_PATTERN));
        verifyName(errors, contact.getMiddleName(), bundle.getString(NAME_PATTERN));
        verifyName(errors, contact.getLastName(), bundle.getString(NAME_PATTERN));
        verifyLogin(errors, contact.getLogin(), bundle.getString(LOGIN_PATTERN));
        verifyComment(errors, contact.getComment(), bundle.getString(COMMENT_PATTERN));
        verifyHomePhone(errors, contact.getHomePhone(), bundle.getString(HOME_PHONE_PATTERN));
        verifyMobile(errors, contact.getMobile(), bundle.getString(MOBILE_PHONE_PATTERN));
        verifyEmail(errors, contact.getEmail(), bundle.getString(EMAIL_PATTERN));
        verifySkype(errors, contact.getSkype(), bundle.getString(SKYPE_PATTERN));
        verifyPostcode(errors, contact.getAddress().getPostcode().toString(), bundle.getString(POSTCODE_PATTERN));
        verifyCityStreet(errors, contact.getAddress().getCity(), bundle.getString(CITY_STREET_PATTERN));
        verifyCityStreet(errors, contact.getAddress().getStreet(), bundle.getString(CITY_STREET_PATTERN));
        verifyHouseApartmentNumber(errors, contact.getAddress().getHouseNumber().toString(), bundle.getString(NUMBER_PATTERN));
        verifyHouseApartmentNumber(errors, contact.getAddress().getApartmentNumber().toString(), bundle.getString(NUMBER_PATTERN));

        return errors;
    }

    static void checkUniquenessInput(Model model, Contact contact) throws NotUniqueFieldException {
        model.checkLogin(contact.getLogin());
        model.checkMobile(contact.getMobile());
        model.checkEmail(contact.getEmail());
        model.checkSkype(contact.getSkype());
    }

    private static void verifyName(List<String> errors, String firstName, String pattern) {
        if (!firstName.matches(pattern)) {
            errors.add("First name, middle name and last name must be in format " + NAME_PATTERN);
        }
    }

    private static void verifyLogin(List<String> errors, String login, String pattern) {
        if (!login.matches(pattern)) {
            errors.add("Login must be in format " + LOGIN_PATTERN);
        }

    }

    private static void verifyComment(List<String> errors, String comment, String pattern) {
        if (!comment.matches(pattern)) {
            errors.add("Field comment can not be empty!");
        }
    }

    private static void verifyHomePhone(List<String> errors, String homePhone, String pattern) {
        if (!homePhone.matches(pattern)) {
            errors.add("Home phone must be in format " + HOME_PHONE_PATTERN);
        }
    }

    private static void verifyMobile(List<String> errors, String mobile, String pattern) {
        if (!mobile.matches(pattern)) {
            errors.add("Mobile phone must be in format " + MOBILE_PHONE_PATTERN);
        }
    }

    private static void verifyEmail(List<String> errors, String email, String pattern) {
        if (!email.matches(pattern)) {
            errors.add("Email must be in format " + EMAIL_PATTERN);
        }
    }

    private static void verifySkype(List<String> errors, String skype, String pattern) {
        if (!skype.matches(pattern)) {
            errors.add("Skype must be in format " + SKYPE_PATTERN);
        }
    }

    private static void verifyPostcode(List<String> errors, String postcode, String pattern)
            throws NumberFormatException {
        if (!postcode.matches(pattern)) {
            errors.add("Postcode must be in format " + POSTCODE_PATTERN);
        }
    }

    private static void verifyCityStreet(List<String> errors, String city, String pattern) {
        if (!city.matches(pattern)) {
            errors.add("City and street must be in format " + CITY_STREET_PATTERN);
        }
    }

    private static void verifyHouseApartmentNumber(List<String> errors, String number, String pattern)
            throws NumberFormatException {
        if (!number.matches(pattern)) {
            errors.add("House and apartment number must be in format " + NUMBER_PATTERN);
        }
    }
}
