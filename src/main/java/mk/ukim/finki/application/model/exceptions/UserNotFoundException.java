package mk.ukim.finki.application.model.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super(String.format("User with id: %ld was not found!",id));
    }
}
