package mk.ukim.finki.application.model.exceptions;

public class UserWithUsernameNotFoundException extends RuntimeException{

    public UserWithUsernameNotFoundException(String username) {
        super(String.format("User with username: %s was not found!", username));
    }
}
