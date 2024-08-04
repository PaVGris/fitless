package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Table(name = "\"Workout\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workout {

    @Id
    @Column(name = "work_id")@SequenceGenerator(name = "workoutIdSeq", sequenceName = "work_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workoutIdSeq")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "work_date")
    private Date workDate;

    @Column(name = "start_time")
    private Integer startTime;

    @Column(name = "end_time")
    private Integer endTime;

    @Column(name = "activity")
    private String activity;

    @Column(name = "client_id")
    private Long client_id;

    @ManyToOne()
    @JoinColumn(name = "room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    private Room room;

    @ManyToOne()
    @JoinColumn(name = "trainer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Trainer trainer;

    public Workout(Date workDate, Long client_id, Integer startTime, Integer endTime, String activity, Room room, Trainer trainer) {
        this.workDate = workDate;
        this.client_id = client_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
        this.room = room;
        this.trainer = trainer;
    }

    //без клиента

}
