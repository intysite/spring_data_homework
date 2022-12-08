package org.example.spring_data_homework.repository;

import org.example.spring_data_homework.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDao extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerName(String customerName);
}
