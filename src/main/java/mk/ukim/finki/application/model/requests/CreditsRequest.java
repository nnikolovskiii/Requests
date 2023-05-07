package mk.ukim.finki.application.model.requests;

import lombok.Data;
import mk.ukim.finki.application.model.Course;
import mk.ukim.finki.application.model.Professor;

import javax.persistence.*;

@Entity
@Data
public class CreditsRequest extends RequestDecorator{

    @OneToOne
    private Professor professor;

    @OneToOne
    private Course course;

    public CreditsRequest(BaseRequest request, Professor professor, Course course) {
        super(request);
        this.professor = professor;
        this.course = course;
    }

    public CreditsRequest() {

    }
}
