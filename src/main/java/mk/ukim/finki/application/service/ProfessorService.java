package mk.ukim.finki.application.service;

import mk.ukim.finki.application.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> listAll();
    Professor findById(Long profId);
    Professor findByName(String name);

    Professor add(String name, String surname, String email);
    Professor edit(Long id, String name, String surname, String email);

    void deleteById(Long profId);
    void deleteByName(String name);
}
