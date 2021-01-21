package com.example.CoursesLabJava.repositories;

import com.example.CoursesLabJava.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findByCoursesId(Long id);

    List<Customer> findByTownIgnoreCaseAndCoursesId(String town, Long id);

    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndCoursesId(int age, String town, Long id);
}
