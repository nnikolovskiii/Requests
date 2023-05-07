package mk.ukim.finki.application.web;
import mk.ukim.finki.application.model.enums.ApplicationType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/applicationTypes")
public class ApplicationTypeRestController {

    @GetMapping
    public List<ApplicationType> findAll() {
        return Arrays.stream(ApplicationType.values()).toList();
    }
}

