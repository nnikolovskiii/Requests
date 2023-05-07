/*
package mk.ukim.finki.application.web;

import mk.ukim.finki.application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final MajorStudiesService majorStudiesService;

    public RegisterController(UserService userService,
                              MajorStudiesService majorStudiesService) {
        this.userService = userService;
        this.majorStudiesService = majorStudiesService;
    }

    @GetMapping
    public String getRegisterPage(Model model) {
        model.addAttribute("majorStudies",majorStudiesService.listAll());
        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @PostMapping
    public String register(HttpServletRequest httpRequest) {
        try {
            this.userService.register(httpRequest);

            return "redirect:/login?SuccessfullyRegistered";
        } catch (Exception e) {
            return "redirect:/register?error="+e.getMessage();
        }
    }
}
*/
