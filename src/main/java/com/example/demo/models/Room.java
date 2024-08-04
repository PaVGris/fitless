package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "\"Room\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @Column(name = "room_id")
    private Long id;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "room_floor")
    private Integer roomFloor;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "training_type")
    private String trainingType;
}
