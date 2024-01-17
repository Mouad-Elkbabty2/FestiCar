package fr.uga.m1miage.example.models;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Offre {

    @EmbeddedId
    private OffreId id;

    @ManyToOne
    @MapsId("idFestival")
    private Festival festival;

    @ManyToOne
    @MapsId("idCovoiturage")
    private Covoiturage covoiturage;

    @Column(name = "tarif")
    private double tarifTotal;

    @Column(name = "nbPlacesDisponibles")
    private int nbPlacesDisp;

}
