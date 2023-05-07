package mk.ukim.finki.application.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseWithIdNotFoundException extends RuntimeException{

    public CourseWithIdNotFoundException(Long id) {
        super(String.format("Course with id: %ld was not found!",id));
    }
}
