package org.example.spring_data_homework.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDtoRq {

    private String room;
    private String customerName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
