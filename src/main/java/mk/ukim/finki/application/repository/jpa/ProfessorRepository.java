package mk.ukim.finki.application.repository.jpa;

import mk.ukim.finki.application.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findProfessorByNameLike(String name);
}
