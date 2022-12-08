package org.example.spring_data_homework.mapper;

import org.example.spring_data_homework.dto.BookingDtoRq;
import org.example.spring_data_homework.dto.BookingDtoRs;
import org.example.spring_data_homework.entity.Booking;
import org.example.spring_data_homework.entity.Room;
import org.example.spring_data_homework.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingMapper {

    @Autowired
    private RoomDao roomDao;

    public Booking castFromDto(BookingDtoRq bookingDtoRq) {
        Optional<Room> room = roomDao.findById(bookingDtoRq.getRoom());
        return new Booking(room.get(),
                bookingDtoRq.getCustomerName(),
                bookingDtoRq.getDateFrom(),
                bookingDtoRq.getDateTo());
    }

    public BookingDtoRs castFromEntity(Booking booking) {
        return BookingDtoRs.builder()
                .room(booking.getRoom().getName())
                .customerName(booking.getCustomerName())
                .dateFrom(booking.getDateFrom())
                .dateTo(booking.getDateTo())
                .build();
    }
}
