package mk.ukim.finki.application.model.exceptions;

public class ApplicationTypeNotFoundException extends RuntimeException{

    public ApplicationTypeNotFoundException(Long id) {
        super(String.format("Application type with id: %ld was not found!",id));
    }
}
