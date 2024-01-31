package fr.uga.m1miage.example.models;

import javax.persistence.*;

import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Covoiturage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCovoiturage;

    private int nbPlaces;

    private double tarif;

    private String modelVoiture;
    private String couleur ;
    private String marque ;


    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private Utilisateur utilisateur ;


    @ManyToOne
    @JoinColumn(name="festival_id")


    private Festival festival ;
    private int nbPlacesReservees ;

    @OneToMany(mappedBy = "arretsCovoitId.idCovoiturage")
    private List<ArretCovoiturage> arretCovoiturageList ;


}
