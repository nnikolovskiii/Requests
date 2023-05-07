/*
package mk.ukim.finki.application.service.impl;


import mk.ukim.finki.application.model.users.User;
import mk.ukim.finki.application.model.enums.Role;
import mk.ukim.finki.application.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.application.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.application.model.exceptions.PasswordNotMatchingException;
import mk.ukim.finki.application.model.exceptions.UserNotFoundException;
import mk.ukim.finki.application.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.application.repository.jpa.UserRepository;
import mk.ukim.finki.application.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder
                         ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {

        if(username == null || password == null)
            throw new InvalidArgumentException(username, password);

        return this.userRepository
                .findUserByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }


    @Override
    public User register(HttpServletRequest httpRequest) {

        //todo: ovaa proverka da se napravi na client side, da ne mora da ide do serverot
        String name = httpRequest.getParameter("name");
        String surname = httpRequest.getParameter("surname");
        String email = httpRequest.getParameter("email");
        String username = httpRequest.getParameter("username");
        String password = httpRequest.getParameter("password");
        String passwordRepeat = httpRequest.getParameter("password-repeat");
        String majorStudies = httpRequest.getParameter("majorStudies");
        Role role = Role.USER;


        if (name == null || name.isEmpty() || surname == null || surname.isEmpty())
            throw new InvalidUserCredentialsException();

        if (!password.equals(passwordRepeat))
            throw new PasswordNotMatchingException();

        if(this.userRepository.findUserByUsername(username).isPresent())
            throw new UserAlreadyExistsException(username);

        String encryptedPassword = this.passwordEncoder.encode(password);

        //todo: smeni go ova porano beshe klasa sega napravi go spored Enum
        //todo: stavi go da e student smeni gi i constructori vo Student
        */
/*Student user = new User(
                name,surname,
                username, email,
                encryptedPassword,
                majorStumajdies1,
                role
        );*//*


        //return this.userRepository.save(user);
        return null;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User edit(Long id, String name, String surname, String email, String username, Role role) {
        User u = this.findById(id);

        u.setName(name);
        u.setSurname(surname);

        u.setEmail(email);
        u.setUsername(username);

        u.setRole(role);

        return this.userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User (
                u.getUsername(),
                u.getPassword(),
                Stream.of(new SimpleGrantedAuthority(u.getRole().toString())).collect(Collectors.toList())
        );

        return userDetails;
    }
}
*/
