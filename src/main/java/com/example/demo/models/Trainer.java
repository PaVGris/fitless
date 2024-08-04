package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Entity
@Table(name = "\"Trainer\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {

    @Id
    @SequenceGenerator(name = "trainerIdSeq", sequenceName = "trainer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainerIdSeq")
    @Column(name = "trainer_id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "middle_name")
    private String middleName;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public long getId() {
//        return id;
//    }

    public Trainer(String firstName, String lastName, String middleName, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.middleName = middleName;
        this.phone = phone;
        this.password = password;
    }

}
