package com.example.CoursesLabJava.repositories;

import com.example.CoursesLabJava.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByDateIgnoreCase(String date);

}
