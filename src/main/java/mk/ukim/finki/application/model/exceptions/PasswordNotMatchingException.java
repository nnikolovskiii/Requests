package mk.ukim.finki.application.model.exceptions;

public class PasswordNotMatchingException extends RuntimeException{

    public PasswordNotMatchingException() {
        super(String.format("Passwords not matching!"));
    }
}
