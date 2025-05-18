package org.example.Table;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@Table(name = "SportInventory")
public class SportInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Serial id


    @Column(name = "serial_number")
    private int serial_number;

    @OneToMany(mappedBy = "sportInventory", cascade = CascadeType.ALL)
    private List<BadmintonRacket> racket;

    @OneToMany(mappedBy = "sportInventory", cascade = CascadeType.ALL)
    private List<Shuttlecock> shuttlecock;

    @Column(name = "label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouseId;

    //Конструктор для Hibernate
    public SportInventory() {

    }


    @Override
    public String toString() {
        return "Shuttlecock{" +
                "id=" + serial_number +
                ", name='" + getLabel() + '\'' +
                ", warehouseId='" + warehouseId.getWarehouse_id() + '\'' +
                '}';
    }

}
