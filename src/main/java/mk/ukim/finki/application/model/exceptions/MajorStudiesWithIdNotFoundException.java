package mk.ukim.finki.application.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MajorStudiesWithIdNotFoundException extends RuntimeException{
    public MajorStudiesWithIdNotFoundException(Long id) {
        super(String.format("MajorStudies with id: %ld was not found!",id));
    }
}
