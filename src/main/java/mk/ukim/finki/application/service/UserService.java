package mk.ukim.finki.application.service;


import mk.ukim.finki.application.model.users.User;
import mk.ukim.finki.application.model.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService  {

    User login(String username, String password);

    User register(HttpServletRequest httpRequest);

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    void deleteById(Long id);

    User edit(Long id, String name, String surname, String email,
              String username, Role role);
}
