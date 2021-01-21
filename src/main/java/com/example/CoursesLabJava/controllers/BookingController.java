package com.example.CoursesLabJava.controllers;

import com.example.CoursesLabJava.models.Booking;
import com.example.CoursesLabJava.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookingsOrDate(
            @RequestParam(required = false, name = "date") String date) {
        if (date != null) {
            return new ResponseEntity<>(bookingRepository.findAllByDateIgnoreCase(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
