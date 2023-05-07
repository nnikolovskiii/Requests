package mk.ukim.finki.application.service;

import mk.ukim.finki.application.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> listAll();
    Course findById(Long courseId);
    Course findByName(String name);

    Course add(String name, String description);
    Course edit(Long id, String name, String description);

    void deleteById(Long courseId);
    void deleteByName(String name);
}
