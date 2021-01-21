package com.example.CoursesLabJava.controllers;

import com.example.CoursesLabJava.models.Course;
import com.example.CoursesLabJava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCoursesAndFilters(
            @RequestParam( required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "customerId") Long id
    ) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByStarRating(rating), HttpStatus.OK);
        }
        if (id != null) {
            return new ResponseEntity<>(courseRepository.findByCustomersId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}

//    List<Course> findByStarRating(int starRating);
//
//    List<Course> findByCustomersId(Long id);