package mk.ukim.finki.application.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String email;

    public Professor() {
        name = "prof";
        surname = "surname";
        email = "email";
    }

    public Professor(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
