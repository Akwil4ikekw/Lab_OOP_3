package org.example.Table;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table (name = "BadmintonRacket")
public class BadmintonRacket extends Item {


    @ManyToOne
    @JoinColumn(name = "SportInventoryId")
    SportInventory sportInventory;

    @Column(name = "string_tension")
    private int string_tension;

    @Column(name = "rigidity_racket")
    private String rigidity_racket;



    public BadmintonRacket() {

    }
    protected Class<BadmintonRacket> getEntityClass() {
        return BadmintonRacket.class;
    }



    @Override
    public String toString() {
        return "Racket{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", string_tension='" + string_tension  + '\'' +
                ", rigidity_racket='" + rigidity_racket + '\'' +
                "id_inventory='" + getSportInventory().getSerial_number() + '\'' +
                '}'
                ;
    }


}
