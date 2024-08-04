package com.example.demo.controllers;


import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Room;
import com.example.demo.models.Trainer;
import com.example.demo.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
@Slf4j
public class RoomController {
        private final RoomRepository roomRepository;

        @GetMapping("/rooms")
        public List<Room> getAllRooms() {
            List<Room> rooms = roomRepository.getAllRooms();
            return rooms;
        }

        @GetMapping("/tutorials/{id}")
        public ResponseEntity<Room> getRoomById(@PathVariable("id") long id) {
            Room tutorial = roomRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found Room with id = " + id));

            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        }
}
