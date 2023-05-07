package mk.ukim.finki.application.web;


import mk.ukim.finki.application.model.*;
import mk.ukim.finki.application.model.enums.ApplicationType;
import mk.ukim.finki.application.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @GetMapping
    public String getApplicationsPage(Model model) {
        List<Application> applications = this.applicationService.findAll();

        model.addAttribute("applications", applications);

        model.addAttribute("bodyContent", "applications");
        return "master-template";
    }

    @GetMapping("/add")
    public String addNewApplication(Model model) {
        model.addAttribute("bodyContent", "addApplication");
        model.addAttribute("applicationTypes", ApplicationType.values());
        return "master-template";
    }

    @PostMapping("/add")
    public String addNewApplication(@RequestParam ApplicationType applicationType,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {


            this.applicationService.save(dateFrom, dateTo, applicationType);
            return "master-template";
    }

    @GetMapping("/{id}/edit")
    public String showEditApplication(@PathVariable Long id, Model model) {
        Application application = this.applicationService.findById(id);
        model.addAttribute("application",application);
        model.addAttribute("applicationTypes",ApplicationType.values());
        model.addAttribute("bodyContent","addApplication");
        return "master-template";
    }

    @PostMapping("/add/{id}")
    public String editApplication(@PathVariable Long id,
                                  @RequestParam ApplicationType applicationType,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        this.applicationService.update(id, applicationType, dateFrom, dateTo);

        return "redirect:/home";
    }
}
