package mk.ukim.finki.application.service.impl;

import mk.ukim.finki.application.model.Professor;
import mk.ukim.finki.application.model.exceptions.ProfessorWithIdNotFoundException;
import mk.ukim.finki.application.repository.jpa.ProfessorRepository;
import mk.ukim.finki.application.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> listAll() {
        return this.professorRepository.findAll();
    }

    @Override
    public Professor findById(Long profId) {
        return this.professorRepository.findById(profId)
                .orElseThrow(() -> new ProfessorWithIdNotFoundException(profId));
    }

    @Override
    public Professor findByName(String name) {
        return this.professorRepository.findProfessorByNameLike(name);
    }

    @Override
    public Professor add(String name, String surname, String email) {
        Professor professor = new Professor(name, surname, email);
        return this.professorRepository.save(professor);
    }

    @Override
    public Professor edit(Long id, String name, String surname, String email) {
        Professor professor = this.findById(id);

        professor.setName(name);
        professor.setSurname(surname);
        professor.setEmail(email);

        return this.professorRepository.save(professor);
    }

    @Override
    public void deleteById(Long profId) {
        this.professorRepository.deleteById(profId);
    }

    @Override
    public void deleteByName(String name) {
        Professor professor = this.professorRepository.findProfessorByNameLike(name);
        this.professorRepository.delete(professor);
    }
}
