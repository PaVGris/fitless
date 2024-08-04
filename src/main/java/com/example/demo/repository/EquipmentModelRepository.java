package com.example.demo.repository;

import com.example.demo.models.Client;
import com.example.demo.models.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, Long> {
    @Query(value = "select c from EquipmentModel c where c.modelType = ?1")
    List<Client> findByModelType(String modelType);
}
