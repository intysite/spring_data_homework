package org.example.spring_data_homework.repository;

import org.example.spring_data_homework.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, String> {
}
