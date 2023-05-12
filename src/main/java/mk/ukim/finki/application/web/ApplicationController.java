/*
package mk.ukim.finki.application.web;


import mk.ukim.finki.application.model.*;
import mk.ukim.finki.application.model.dto.ApplicationDto;
import mk.ukim.finki.application.model.enums.ApplicationType;
import mk.ukim.finki.application.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getApplications() {
        return applicationService.findAll();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return applicationService.findById(id);
    }

    @PostMapping
    public Application createApplication(@RequestBody ApplicationDto applicationDTO) {
        LocalDateTime dateFrom = applicationDTO.getDateFrom();
        LocalDateTime dateTo = applicationDTO.getDateTo();
        ApplicationType applicationType = applicationDTO.getApplicationType();
        return applicationService.save(dateFrom, dateTo, applicationType);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable Long id, @RequestBody ApplicationDto applicationDTO) {
        LocalDateTime dateFrom = applicationDTO.getDateFrom();
        LocalDateTime dateTo = applicationDTO.getDateTo();
        ApplicationType applicationType = applicationDTO.getApplicationType();
        Optional<Application> updatedApplication = applicationService.update(id, applicationType, dateFrom, dateTo);
        return updatedApplication.orElseThrow(() -> new ResourceNotFoundException("Application not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}*/
