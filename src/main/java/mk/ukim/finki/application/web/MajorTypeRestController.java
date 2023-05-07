package mk.ukim.finki.application.web;

import mk.ukim.finki.application.model.enums.MajorType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/majors") // /api/ ...
public class MajorTypeRestController {

    @GetMapping
    public List<MajorType> findAll() {
        return Arrays.stream(MajorType.values()).toList();
    }
}
