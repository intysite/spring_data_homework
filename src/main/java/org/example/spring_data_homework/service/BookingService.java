package org.example.spring_data_homework.service;

import lombok.AllArgsConstructor;
import org.example.spring_data_homework.dto.BookingDtoRq;
import org.example.spring_data_homework.dto.BookingDtoRs;
import org.example.spring_data_homework.entity.Booking;
import org.example.spring_data_homework.mapper.BookingMapper;
import org.example.spring_data_homework.repository.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookingService {
    private BookingMapper bookingMapper;
    private BookingDao bookingDao;

    public Long createBooking(BookingDtoRq bookingDtoRq) {
        Booking booking = bookingMapper.castFromDto(bookingDtoRq);
        bookingDao.save(booking);
        return booking.getId();
    }

    public List<BookingDtoRs> getBookingByCustomer(String customerName) {
        return bookingDao.findByCustomerName(customerName).stream()
                .map(e -> bookingMapper.castFromEntity(e))
                .collect(Collectors.toList());
    }

    public BookingDtoRs getBookingById(Long id) {
        Optional<Booking> byId = bookingDao.findById(id);
        return bookingMapper.castFromEntity(byId.get());
    }

    public Boolean deleteBooking(Long id) {
        try {
            if(bookingDao.findById(id).isEmpty()) {
                return false;
            }
            bookingDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
