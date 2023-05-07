package mk.ukim.finki.application.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessorWithIdNotFoundException extends RuntimeException{
    public ProfessorWithIdNotFoundException(Long id) {
        super(String.format("Professor with id: %ld was not found!",id));
    }
}
