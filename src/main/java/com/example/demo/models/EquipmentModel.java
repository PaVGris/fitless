package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "\"Equipment Model\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentModel {

    @Id
    @Column(name = "equip_model_id")
    private Long id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "model_type")
    private String modelType;

    @Column(name = "manufacturer")
    private String manufacturer;

//    EquipmentModel(Long id, String modelName, String modelType, String manufacturer) {
//        this.id = id;
//        this.modelName = modelName;
//        this.modelType = modelType;
//        this.manufacturer = manufacturer;
//    }
}
