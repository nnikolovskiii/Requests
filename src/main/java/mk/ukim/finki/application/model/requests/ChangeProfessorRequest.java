package mk.ukim.finki.application.model.requests;


import lombok.Data;
import mk.ukim.finki.application.model.Course;
import mk.ukim.finki.application.model.Professor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class ChangeProfessorRequest extends RequestDecorator{
    @OneToOne
    private Course course;

    @OneToOne
    private Professor currentProfessor;

    @OneToOne
    private Professor newProfessor;

    public ChangeProfessorRequest(BaseRequest request,
                                  Course course,
                                  Professor currentProfessor,
                                  Professor newProfessor) {
        super(request);
        this.course = course;
        this.currentProfessor = currentProfessor;
        this.newProfessor = newProfessor;
    }

    public ChangeProfessorRequest() {

    }
}
