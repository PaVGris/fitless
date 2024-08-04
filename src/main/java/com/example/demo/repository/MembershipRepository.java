package com.example.demo.repository;


import com.example.demo.models.Membership;
import com.example.demo.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.models.Client;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Query(value = "SELECT x FROM Membership x WHERE x.client_id = ?1")
    Optional<Membership> findByClientId(Long id);

}
