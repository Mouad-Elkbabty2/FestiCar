package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pack {

    @EmbeddedId
    private PackId idPack;

    private int nbPlacesReserves;


}
