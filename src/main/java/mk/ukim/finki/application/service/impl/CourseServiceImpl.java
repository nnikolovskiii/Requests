package mk.ukim.finki.application.service.impl;

import mk.ukim.finki.application.model.Course;
import mk.ukim.finki.application.model.exceptions.CourseWithIdNotFoundException;
import mk.ukim.finki.application.repository.jpa.CourseRepository;
import mk.ukim.finki.application.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> listAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findById(Long courseId) {
        return this.courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseWithIdNotFoundException(courseId));
    }

    @Override
    public Course findByName(String name) {
        return this.courseRepository.findCourseByNameLike(name);
    }

    @Override
    public Course add(String name, String description) {
        Course course = new Course(name, description);
        return this.courseRepository.save(course);
    }

    @Override
    public Course edit(Long id, String name, String description) {
        Course course = this.findById(id);

        course.setName(name);
        course.setDescription(description);

        return this.courseRepository.save(course);
    }

    @Override
    public void deleteById(Long courseId) {
        this.courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteByName(String name) {
        Course course = this.courseRepository.findCourseByNameLike(name);
        this.courseRepository.delete(course);
    }
}
