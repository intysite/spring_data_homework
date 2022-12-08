package org.example.spring_data_homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Room {
    @Id
    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private RoomGrade roomGrade;

    @OneToMany(mappedBy = "room")
    private List<Booking> booking;
}
