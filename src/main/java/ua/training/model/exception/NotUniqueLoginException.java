package ua.training.model.exception;

public class NotUniqueLoginException extends Exception {
    public NotUniqueLoginException(String message) {
        super(message);
    }
}
