package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Trainer;
import com.example.demo.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
@Slf4j
public class TrainerController {

    private final TrainerRepository trainerRepository;

    // get all employees

    @GetMapping("/trainer/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        Trainer trainer = trainerRepository.findByMyId(id).orElseThrow(() -> new ResourceNotFoundException("Trainer not exist with id :" + id));
        return ResponseEntity.ok(trainer);
    }

    @GetMapping("/trainer/phone/{phone}")
    public ResponseEntity<Trainer> getTrainerByPhone(@PathVariable String phone) {
        Trainer trainer = trainerRepository.findByPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Trainer not exist with id :" + phone));
        return ResponseEntity.ok(trainer);
    }

    @GetMapping("/trainers")
    public List<Trainer> getAllTrainers(){
        return trainerRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/save_trainer")
    public Trainer createEmployee(@RequestBody Trainer employee) {
        return trainerRepository.save(employee);
    }

    // get employee by id rest api
    @GetMapping("/trainers/{id}")
    public ResponseEntity<Trainer> getEmployeeById(@PathVariable Long id) {
        Trainer employee = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/trainers-l/{lastName}")
    public ResponseEntity<Trainer> getTrainerByLastName(@PathVariable String lastName) {
        Trainer employee = trainerRepository.findByLastName(lastName)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with name :" + lastName));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/trainers/{lastName}/{firstName}")
    public ResponseEntity<Trainer> getTrainerByFirstNameAndLastName(@PathVariable String lastName, @PathVariable String firstName) {
        Trainer employee = trainerRepository.findByFirstNameAndLastName(lastName, firstName)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with name :" + firstName + lastName));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/trainers/{lastName}/{firstName}/{middleName}")
    public ResponseEntity<Trainer> getTrainerByName(@PathVariable String lastName, @PathVariable String firstName, @PathVariable String middleName) {
        Trainer employee = trainerRepository.findByName(lastName, firstName, middleName)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with name :" + firstName + lastName + middleName));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(value = "/trainerDelete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        try {
            trainerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update employee rest api
    @PutMapping(value = "/trainers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody Trainer employeeDetails){
        log.info("{}", employeeDetails);
        Trainer employee = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        employee.setMiddleName(employeeDetails.getMiddleName());
        employee.setPassword(employeeDetails.getPassword());

        Trainer updatedTrainer = trainerRepository.save(employee);
        return ResponseEntity.ok(updatedTrainer);
    }

}
