package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Client;
import com.example.demo.models.Membership;
import com.example.demo.models.Trainer;
import com.example.demo.models.Workout;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.MembershipRepository;
import com.example.demo.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
@Slf4j
public class ClientController {
    private final WorkoutRepository workoutRepository;

    private final ClientRepository clientRepository;
    private final MembershipRepository membershipRepository;

    // get employee by id rest api
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("client not exist with id :" + id));
        return ResponseEntity.ok(client);
    }
    @GetMapping("/mem/{id}")
    public ResponseEntity<Membership> getMem(@PathVariable Long id) {
        Membership membership = membershipRepository.findByClientId(id)
                .orElseThrow(() -> new ResourceNotFoundException("client not exist with id :" + id));
        return ResponseEntity.ok(membership);
    }

    @PutMapping(value = "/client/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateTrainer(@PathVariable Long id, @RequestBody Client clientDetails){
        log.info("{}", clientDetails);
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setPassword(clientDetails.getPassword());

        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }
    @PutMapping(value = "/client/pay/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Membership> updateMembership(@PathVariable Long id, @RequestBody Membership memDetails){
        log.info("{}", memDetails);
        Membership mem = membershipRepository.findByClientId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Membership not exist with id :" + id));

        mem.setStatus(memDetails.getStatus());
        mem.setPro_plan(memDetails.getPro_plan());
        mem.setStart_date(memDetails.getStart_date());
        mem.setEnd_date(memDetails.getEnd_date());

        Membership updatedmem = membershipRepository.save(mem);
        return ResponseEntity.ok(updatedmem);
    }
    @GetMapping("/client/phone/{phone}")
    public ResponseEntity<Client> getClientByPhone(@PathVariable String phone) {
        Client client = clientRepository.findByPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Trainer not exist with id :" + phone));
        return ResponseEntity.ok(client);
    }
    @GetMapping("client/workout/{id}")
    public ResponseEntity<List<Workout>> getAllByClientId(@PathVariable Long id) {
        List<Workout> trainings = workoutRepository.getAllClientWorkouts(id);
        return ResponseEntity.ok(trainings);
    }
    @PostMapping("/client/newWorkout")
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }
}