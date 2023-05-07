package mk.ukim.finki.application.model.exceptions;

public class ApplicationUserNotFoundException extends RuntimeException{

    public ApplicationUserNotFoundException(Long id) {
        super(String.format("Application user with id: %ld was not found!",id));
    }
}
