/*
package mk.ukim.finki.application.web;

import mk.ukim.finki.application.model.users.User;
import mk.ukim.finki.application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent","login");
        return "master-template";
    }

    @PostMapping
    public String loginUser(HttpServletRequest request) {
        User user = null;

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            user = this.userService.login(username, password);
            request.getSession().setAttribute("user", user);

            return "redirect:/applications";
        } catch (Exception e) {
            System.out.println("Login - " + e.getMessage());
            return "redirect:/login?error=" + e.getMessage();
        }
    }

}
*/
