package mk.ukim.finki.application.model.exceptions;

public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException(String username, String password) {
        super(String.format("Username %s or Password %s is invalid!", username, password));
    }
}
