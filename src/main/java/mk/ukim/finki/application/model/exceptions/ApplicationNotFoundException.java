package mk.ukim.finki.application.model.exceptions;

public class ApplicationNotFoundException extends RuntimeException{

    public ApplicationNotFoundException(Long id) {
        super(String.format("Application with id: %ld was not found!",id));
    }
}
