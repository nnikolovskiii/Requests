package mk.ukim.finki.application.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToMany
    private List<Professor> professors;

    public Course() {
        name = "course";
        description = "description";

    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
