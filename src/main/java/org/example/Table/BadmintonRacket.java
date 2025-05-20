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
        return "Racket{" +'\n'+
                "ID ракетик:" + getId() +'\n'+
                " Название:'" + getName() + '\n' +
                " Натяжение ракетки:'" + string_tension  + '\n'+
                " Жесткость ракет:'" + rigidity_racket + '\n' +
                "ID инвентаря:'" + getSportInventory().getSerial_number() + '\n' +
                '}'
                ;
    }


}
