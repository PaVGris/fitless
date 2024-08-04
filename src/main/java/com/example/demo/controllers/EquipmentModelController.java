package com.example.demo.controllers;

import com.example.demo.models.EquipmentModel;
import com.example.demo.repository.EquipmentModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
@Slf4j
public class EquipmentModelController {

    private final EquipmentModelRepository equipmentModelRepository;

    @GetMapping("/models")
    public List<EquipmentModel> getAllTrainers(){
        return  equipmentModelRepository.findAll();
    }
}
