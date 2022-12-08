package org.example.spring_data_homework.dto;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@Builder
public class BookingDtoRs {
    private String room;
    private String customerName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
