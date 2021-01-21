package com.example.CoursesLabJava.repositories;

import com.example.CoursesLabJava.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStarRating(int starRating);

    List<Course> findByCustomersId(Long id);
}
