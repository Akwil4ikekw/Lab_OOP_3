package org.example.Table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Item")
@Inheritance(strategy = InheritanceType.JOINED)//Наследование
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column (name = "manufacture")
    private String manufacture;

    }
