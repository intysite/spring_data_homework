package org.example.spring_data_homework.controller;

import lombok.AllArgsConstructor;
import org.example.spring_data_homework.dto.BookingDtoRq;
import org.example.spring_data_homework.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/booking")
    public Long createBooking(@RequestBody BookingDtoRq bookingDtoRq) {
        return bookingService.createBooking(bookingDtoRq);
    }

    @GetMapping("/booking")
    public ResponseEntity getBookingByCustomer(@RequestParam String name) {
        if (name == null) {
            return new ResponseEntity<>("Имя клиента не задано", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(bookingService.getBookingByCustomer(name), HttpStatus.OK);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Номер бронирования не задан", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(bookingService.getBookingById(id), HttpStatus.OK);
    }

    @DeleteMapping("/booking/{id}")
    public Boolean deleteBooking(@PathVariable Long id) {
        return bookingService.deleteBooking(id);
    }
}
