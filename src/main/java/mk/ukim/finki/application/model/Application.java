package mk.ukim.finki.application.model;


import javax.persistence.*;
import lombok.Data;
import mk.ukim.finki.application.model.enums.ApplicationType;

import java.time.LocalDateTime;

/**
 * These are the applications from which students can choose to make an individual application.
 *
 */

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApplicationType applicationType;

//    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime dateFrom;

//    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime dateTo;

    public Application(LocalDateTime dateFrom, LocalDateTime dateTo, ApplicationType applicationType) {
        this.applicationType = applicationType;
        this.dateFrom = dateFrom;
        this.dateTo  = dateTo;    }

    public Application() {
        applicationType = ApplicationType.PAYMENT_INSTALLMENTS;
        dateFrom = LocalDateTime.now();
        dateTo = LocalDateTime.now();
    }
}
