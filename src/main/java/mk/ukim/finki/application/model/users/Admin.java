package mk.ukim.finki.application.model.users;

import lombok.Data;
import mk.ukim.finki.application.model.users.User;

import javax.persistence.Entity;

@Entity
@Data
public class Admin extends User {
}
