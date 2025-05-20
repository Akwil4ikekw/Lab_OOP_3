package org.example.Table;
import jakarta.persistence.Entity;
import lombok.Data;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "Shuttlecocks")
public class Shuttlecock extends Item{


    @ManyToOne
    @JoinColumn(name = "SportInventoryId")
    SportInventory sportInventory;

    @Column(name = "type_shuttlecock")
    private String typeShuttlecock;

    @Column(name = "resistance_to_fly")
    private String resistanceToFly;


    public Shuttlecock() {

    }


    @Override
    public String toString() {
        return "Shuttlecock{" + '\n'+
                "ID: " + getSportInventory().getSerial_number() +'\n'+
                " Название: " + getName() + '\n' +
                " Тип волана: " + typeShuttlecock + '\n' +
                " Сопротивление к воздуху: " + resistanceToFly + '\n' +
                '}';
    }


}
