package com.example.demo.controllers;


import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Room;
import com.example.demo.models.Trainer;
import com.example.demo.models.Workout;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
@Slf4j
public class WorkoutController {
    private final WorkoutRepository workoutRepository;
    private final RoomRepository roomRepository;


    @GetMapping("/workouts/{id}")
    public ResponseEntity<List<Workout>> getAllByTrainerId(@PathVariable Long id) {
        List<Workout> trainings = workoutRepository.getAllByTrainerId(id);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/workout/{id}")
    public ResponseEntity<List<Workout>> getByWorkoutId(@PathVariable Long id) {
        List<Workout> trainings = workoutRepository.getByWorkoutId(id);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/workouts")
    public ResponseEntity<List<Workout>> getAllByTrainerId() {
        List<Workout> trainings = workoutRepository.getAllWorkouts();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/workouts/{workDate}/{time}")
    public ResponseEntity<List<Room>> getWorkoutsByTime(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date workDate, @PathVariable Integer time) {
        List<Workout> trainings = workoutRepository.getWorkoutByStartTimeAndEndTime(workDate, time);
        List<Room> rooms = roomRepository.getAllRooms();

        for (Workout work: trainings) {
            Room tmp = work.getRoom();
            for (int i = 0; i < rooms.size(); i++) {
                if (Objects.equals(tmp.getId(), rooms.get(i).getId())){
                    rooms.get(i).setCapacity(tmp.getCapacity() - 1);
                    if (tmp.getCapacity() == 0) {
                        rooms.remove(rooms.get(i));
                    }
                }
            }
        }
        return ResponseEntity.ok(rooms);
    }

    @PutMapping(value = "/work-upload/{id}/{roomNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @PathVariable Integer roomNumber, @RequestBody Workout workoutDetails){
        log.info("{}", workoutDetails);
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        Room room = workout.getRoom();
        room.setRoomNumber(roomNumber);
        room.setRoomFloor(roomNumber/100);
        workout.setRoom(room);
        Workout updatedWorkout = workoutRepository.save(workout);
        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping(value = "/workout-delete/{id}")
    public ResponseEntity<Long> deleteWorkoutById(@PathVariable Long id) {
        try {
            workoutRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value = "/workoutDel/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        try {
            workoutRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//
//    @GetMapping("/workouts")
//    public ResponseEntity<List<Workout>> getAllTutorials(@RequestParam(required = false) String title) {
//        List<Workout> workouts = new ArrayList<>();
//
//        if (title == null)
//            workoutRepository.findAll().forEach(workouts::add);
//        else
//            workoutRepository.findByTitleContaining(title).forEach(workouts::add);
//
//        if (workouts.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(workouts, HttpStatus.OK);
//    }
//
//    @GetMapping("/tutorials/{id}")
//    public ResponseEntity<Workout> getTutorialById(@PathVariable("id") long id) {
//        Workout tutorial = workoutRepository.getTutorialById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
//
//        return new ResponseEntity<>(tutorial, HttpStatus.OK);
//    }
}
