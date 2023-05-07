
package mk.ukim.finki.application.service;


import mk.ukim.finki.application.model.Application;
import mk.ukim.finki.application.model.enums.ApplicationType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public interface ApplicationService {

    List<Application> findAll();

    Application findById(Long id);

    void deleteById(Long id);

    Application save(LocalDateTime dateFrom, LocalDateTime dateTo, ApplicationType applicationType);

    Optional<Application> update(Long id, ApplicationType applicationType, LocalDateTime dateFrom, LocalDateTime dateTo);
}

