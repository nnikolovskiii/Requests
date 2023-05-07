package mk.ukim.finki.application.model.users;


import javax.persistence.*;
import lombok.Data;
import mk.ukim.finki.application.model.enums.Role;

@Entity
@Data
@Table(name="application_user")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
