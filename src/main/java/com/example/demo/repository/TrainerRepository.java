package com.example.demo.repository;

import com.example.demo.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long>{
    @Query("SELECT t FROM Trainer t WHERE t.id = ?1")
    Optional<Trainer> findByMyId(Long id);

    @Query("SELECT t FROM Trainer t WHERE t.phone = ?1")
    Optional<Trainer> findByPhone(String phone);

    @Query("SELECT t FROM Trainer t WHERE t.lastName = ?1")
    Optional<Trainer> findByLastName(String lastName);

    @Query("SELECT t FROM Trainer t WHERE t.firstName = ?1 AND t.lastName = ?2")
    Optional<Trainer> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT t FROM Trainer t WHERE t.firstName = ?1 AND t.lastName = ?2 AND t.middleName = ?3")
    Optional<Trainer> findByName(String firstName, String lastName, String middleName);




}
