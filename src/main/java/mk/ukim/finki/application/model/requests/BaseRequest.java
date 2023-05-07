package mk.ukim.finki.application.model.requests;

import lombok.Data;
import mk.ukim.finki.application.model.Application;
import mk.ukim.finki.application.model.enums.RequestStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class BaseRequest extends AbstractRequest{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Application application;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    private LocalDate submissionDate;


    public BaseRequest(Application application, String description, RequestStatus requestStatus, LocalDate submissionDate) {
        this.application = application;
        this.description = description;
        this.requestStatus = requestStatus;
        this.submissionDate = submissionDate;
    }

    public BaseRequest() {
        this(null, "base", RequestStatus.PENDING,
                LocalDate.now());
    }
}
