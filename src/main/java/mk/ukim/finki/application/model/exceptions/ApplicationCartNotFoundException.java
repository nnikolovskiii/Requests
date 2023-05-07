package mk.ukim.finki.application.model.exceptions;

public class ApplicationCartNotFoundException extends RuntimeException{
    public ApplicationCartNotFoundException(Long cartId) {
        super(String.format("Application cart with id: %ld was not found!",cartId));
    }
}
