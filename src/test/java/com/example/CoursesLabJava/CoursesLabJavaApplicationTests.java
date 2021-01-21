package com.example.CoursesLabJava;

import com.example.CoursesLabJava.repositories.BookingRepository;
import com.example.CoursesLabJava.repositories.CourseRepository;
import com.example.CoursesLabJava.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoursesLabJavaApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetBookingsByDate() {
		assertEquals(1, bookingRepository.findAllByDateIgnoreCase("2020-12-02").size());
	}

	@Test
	public void canGetCoursesByRating() {
		assertEquals(1, courseRepository.findByStarRating(1).size());
	}

	@Test
	public void canGetCoursesByCustomer() {
		assertEquals(2, courseRepository.findByCustomersId(1L).size());
		assertEquals("Java", courseRepository.findByCustomersId(1L).get(0).getName());
	}

	@Test
	public void canFindCustomerByCourseID() {
		assertEquals(1, customerRepository.findByCoursesId(1L).size());
	}

	@Test
	public void canFindCustomerByTownAndCourse() {
		assertEquals(1, customerRepository.findByTownIgnoreCaseAndCoursesId("Edinburgh", 1L).size());
	}

	@Test
	public void canFindCustomerWithAgeGreaterThanAndTownAnCourse() {
		assertEquals(1, customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndCoursesId(17, "Edinburgh", 1L).size());
	}

// Age greater than - town - given course
}

