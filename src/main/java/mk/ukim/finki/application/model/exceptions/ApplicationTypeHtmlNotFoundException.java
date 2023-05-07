package mk.ukim.finki.application.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationTypeHtmlNotFoundException extends RuntimeException{
    public ApplicationTypeHtmlNotFoundException(String applicationTypeName) {
        super(String.format("Html file: %s was not found!",applicationTypeName));
    }
}
