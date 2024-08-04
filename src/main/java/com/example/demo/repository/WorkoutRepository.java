package com.example.demo.repository;


import com.example.demo.models.Trainer;
import com.example.demo.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query("SELECT DISTINCT t FROM Workout t JOIN FETCH t.room WHERE t.trainer.id = ?1")
    List<Workout> getAllByTrainerId(Long id);

    @Query("SELECT t FROM Workout t JOIN FETCH t.room WHERE t.id = ?1")
    List<Workout> getByWorkoutId(Long id);


    @Query("SELECT t FROM Workout t JOIN FETCH t.room WHERE t.workDate = ?1 and ?2 between t.startTime and t.endTime")
    List<Workout> getWorkoutByStartTimeAndEndTime(Date d, Integer time);

    @Query("SELECT DISTINCT t FROM Workout t JOIN FETCH t.room and JOIN fetch t.trainer")
    List<Workout> getAllWorkouts();


    @Query("SELECT DISTINCT t FROM Workout t JOIN FETCH t.room and JOIN fetch t.trainer WHERE t.client_id = ?1 ORDER BY t.workDate")
    List<Workout> getAllClientWorkouts(Long id);

    @Query("SELECT t FROM Workout t JOIN FETCH t.room WHERE t.room.roomNumber = ?1")
    Optional<Trainer> findByRoomNumber(Integer roomNumber);

    List<Workout> findByRoomId(Long roomId);


}