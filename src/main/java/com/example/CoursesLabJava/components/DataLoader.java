package com.example.CoursesLabJava.components;

import com.example.CoursesLabJava.models.Booking;
import com.example.CoursesLabJava.models.Course;
import com.example.CoursesLabJava.models.Customer;
import com.example.CoursesLabJava.repositories.BookingRepository;
import com.example.CoursesLabJava.repositories.CourseRepository;
import com.example.CoursesLabJava.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Java","Edinburgh", 5);
        Course course2 = new Course("Python","Inverness", 4);
        Course course3 = new Course("JavaScript","Glasgow", 1);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Rob", "Edinburgh", 18);
        Customer customer2 = new Customer("Neale", "Burntisland", 18);

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("2020-12-02", customer1, course1);
        Booking booking2 = new Booking("2020-11-02", customer1, course2);
        Booking booking3 = new Booking("2020-10-02", customer2, course2);
        Booking booking4 = new Booking("2020-09-02", customer2, course3);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
    }

}
