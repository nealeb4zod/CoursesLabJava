package com.example.CoursesLabJava.controllers;

import com.example.CoursesLabJava.models.Customer;
import com.example.CoursesLabJava.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomersAndFilters(
            @RequestParam(required = false, name = "id") Long id,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age)
    {
        if(town != null && age != null && id !=null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndCoursesId(
                    age, town, id), HttpStatus.OK);
        }
        if(town != null && id != null){
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndCoursesId(town, id), HttpStatus.OK);
        }
        if(id !=null) {
            return new ResponseEntity<>(customerRepository.findByCoursesId(id), HttpStatus.OK);
        }
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}

//    List<Customer> findByCoursesId(Long id);
//
//    List<Customer> findByTownAndCoursesId(String town, Long id);
//
//    List<Customer> findByAgeGreaterThanAndTownAndCoursesId(int age, String town, Long id);
