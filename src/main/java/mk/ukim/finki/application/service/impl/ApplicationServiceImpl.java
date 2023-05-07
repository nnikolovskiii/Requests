package mk.ukim.finki.application.service.impl;


import mk.ukim.finki.application.model.Application;
import mk.ukim.finki.application.model.enums.ApplicationType;
import mk.ukim.finki.application.model.exceptions.ApplicationAlreadyExistsException;
import mk.ukim.finki.application.model.exceptions.ApplicationNotFoundException;
import mk.ukim.finki.application.model.exceptions.ApplicationTypeNotFoundException;
import mk.ukim.finki.application.model.exceptions.InvalidDateInputException;
import mk.ukim.finki.application.repository.jpa.ApplicationRepository;
import mk.ukim.finki.application.repository.jpa.UserRepository;
import mk.ukim.finki.application.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Application> findAll() {
        return this.applicationRepository.findAll();
    }

    @Override
    public Application findById(Long id) {
        return this.applicationRepository
                .findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
    }

    @Override
    public void deleteById(Long id) {
        this.applicationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Application save(LocalDateTime dateFrom, LocalDateTime dateTo, ApplicationType applicationType) {

        if (dateTo.isBefore(dateFrom))
            throw new InvalidDateInputException(dateTo, dateFrom);

        Application application = new Application(dateFrom, dateTo, applicationType);

        return this.applicationRepository.save(application);
    }

    @Override
    @Transactional
    public Optional<Application> update(Long id, ApplicationType applicationType, LocalDateTime dateFrom,
                                        LocalDateTime dateTo) {

        Application application = this.findById(id);


        application.setApplicationType(applicationType);
        application.setDateFrom(dateFrom);
        application.setDateTo(dateTo);

        return Optional.of(this.applicationRepository.save(application));
    }
}
