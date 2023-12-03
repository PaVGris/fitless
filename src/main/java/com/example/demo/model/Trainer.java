package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "\"Trainer\"")

public class Trainer {

    @Id
    @Column(name = "trainer_id")
    private Long id;

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Column(name = "middle_name")
    private String middleName;

    @Getter
    @Column(name = "email")
    private String email;

    @Getter
    @Column(name = "phone")
    private String phone;

    @Getter
    @Column(name = "password")
    private String password;

    public Trainer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Trainer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


}
