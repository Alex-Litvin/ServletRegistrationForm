package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static int COUNT = 0;

    private static List<Contact> contacts = new ArrayList<>();

    public void printContacts() {
        contacts.forEach(System.out::println);
    }
}
