package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class TrainerController {

    private final TrainerRepository trainerRepository;

    // get all employees
    @GetMapping("/trainers")
    public List<Trainer> getAllEmployees(){
        return trainerRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/trainers")
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

    // update employee rest api
//    @PutMapping("/trainers/{id}")
//    public ResponseEntity<Trainer> updateEmployee(@PathVariable Long id, @RequestBody Trainer employeeDetails){
//        Trainer employee = trainerRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//        employee.setFirstName(employeeDetails.getFirstName());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setEmailId(employeeDetails.getEmailId());
//
//        Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }

    // delete employee rest api
//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//        employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
}
