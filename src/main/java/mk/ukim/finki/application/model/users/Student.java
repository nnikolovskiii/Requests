package mk.ukim.finki.application.model.users;

import lombok.Data;
import mk.ukim.finki.application.model.enums.MajorType;
import mk.ukim.finki.application.model.requests.AbstractRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student extends User {
    @OneToMany
    private List<AbstractRequest> requests;

    @Enumerated(EnumType.STRING)
    private MajorType majorType;
}
