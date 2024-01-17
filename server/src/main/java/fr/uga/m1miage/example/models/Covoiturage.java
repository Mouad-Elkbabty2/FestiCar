package fr.uga.m1miage.example.models;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Data
@NoArgsConstructor

public class Covoiturage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCovoiturage;

    // private Covoitureur covoitureur

    @Column
    private int nbPlaces;

    @Column
    @ManyToMany
    private List<Offre> offresCovoiturage ;

    // private List<Festivalier> festivalier

}