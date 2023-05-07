package mk.ukim.finki.application.model.requests;

import lombok.Data;
import mk.ukim.finki.application.model.Application;
import mk.ukim.finki.application.model.enums.RequestStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AbstractRequest() {

    }
}
