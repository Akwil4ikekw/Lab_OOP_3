package org.example.Table;
import jakarta.persistence.*;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name= "Warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "warehouse_id")
    private int warehouse_id;
    @Column(name= "name")
    private String name;
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "warehouseId", cascade = CascadeType.ALL)
    private List<SportInventory> inventoryList;

    public Warehouse(int warehouse_id, String name, String location) {
        this.warehouse_id = warehouse_id;
        this.name = name;
        this.location = location;
    }
    public Warehouse() {}



}
