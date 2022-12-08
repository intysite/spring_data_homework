package org.example.spring_data_homework.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_name", nullable = false)
    @NonNull
    private Room room;

    @Column(nullable = false)
    @NonNull
    private String customerName;

    @Column
    @CreationTimestamp
    @NonNull
    private LocalDate dateFrom;

    @Column
    @CreationTimestamp
    @NonNull
    private LocalDate dateTo;
}
