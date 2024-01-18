package fr.uga.m1miage.example.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    private int nbPlaces;


    private double tarif ;

    private String modelVoiture ;

    @ManyToOne
    private Covoitureur covoitureur ;

    @ManyToMany
    private List<Festivalier> festivalier ;

    @ManyToMany
    @JsonIgnore
    @NotNull
    private List<LieuCovoiturage> lieuCovoiturageList ;


/*    @ManyToMany
    @NotNull
    @JsonIgnore
    private List<ArretCovoiturage> arretCovoiturageList ;*/
}
