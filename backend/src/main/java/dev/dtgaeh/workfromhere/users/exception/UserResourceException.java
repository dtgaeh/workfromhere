package dev.dtgaeh.workfromhere.users.exception;

public class UserResourceException extends RuntimeException {

    public UserResourceException(String message) {
        super(message);
    }

    public UserResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
