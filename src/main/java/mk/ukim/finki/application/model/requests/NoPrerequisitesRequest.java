package mk.ukim.finki.application.model.requests;


import lombok.Data;
import mk.ukim.finki.application.model.Course;
import mk.ukim.finki.application.model.Professor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class NoPrerequisitesRequest extends RequestDecorator{

    @OneToOne
    private Professor professor;

    @OneToOne
    private Course course;

    public NoPrerequisitesRequest(BaseRequest request, Professor professor, Course course) {
        super(request);
        this.professor = professor;
        this.course = course;
    }


    public NoPrerequisitesRequest() {

    }
}
