package com.example.demo.repository;

import com.example.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNumber(Integer roomNumber);

    @Query("SELECT r FROM Room r")
    List<Room> getAllRooms();

}
