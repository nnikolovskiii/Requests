package mk.ukim.finki.application.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class ApplicationAlreadyExistsException extends RuntimeException{
    public ApplicationAlreadyExistsException(String message) {
        super(String.format(message));
    }
}
