package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@Entity
@Table(name = "\"Membership\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mem_id")
    protected Long mem_id;
    @Column(name = "client_id")
    protected Long client_id;
    @Column(name = "status")
    protected String status;
    @Column(name = "start_date")
    protected Date start_date;
    @Column(name = "end_date")
    protected Date end_date;
    @Column(name = "pro_plan")
    protected Boolean pro_plan;
    public void setStatus(String status) {
        this.status = status;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setPro_plan(Boolean pro_plan) {
        this.pro_plan = pro_plan;
    }
}

