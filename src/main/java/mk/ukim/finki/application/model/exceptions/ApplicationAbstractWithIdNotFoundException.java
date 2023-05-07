package mk.ukim.finki.application.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationAbstractWithIdNotFoundException extends RuntimeException{

    public ApplicationAbstractWithIdNotFoundException(Long id) {
        super(String.format("ApplicationAbstract with id: %ld was not found!",id));
    }
}
