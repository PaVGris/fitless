package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "\"Client\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "client_id")
    protected int client_id;
    @Column(name = "last_name")
    protected String last_name;
    @Column(name = "first_name")
    protected String first_name;
    @Column(name = "middle_name")
    protected String middle_name;
    @Column(name = "gender")
    protected String gender;
    @Column(name = "age")
    protected int age;
    @Column(name = "email")
    protected String email;
    @Column(name = "phone")
    protected String phone;
    @Column(name = "password")
    protected String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
