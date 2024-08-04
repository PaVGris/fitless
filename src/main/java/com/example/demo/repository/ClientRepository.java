package com.example.demo.repository;


import com.example.demo.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT t FROM Client t WHERE t.client_id = ?1")
    Optional<Client> findById(Long id);
    @Query("SELECT t FROM Client t WHERE t.phone = ?1")
    Optional<Client> findByPhone(String phone);
}
