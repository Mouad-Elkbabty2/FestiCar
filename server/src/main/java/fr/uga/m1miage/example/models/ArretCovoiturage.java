package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ArretCovoiturage {

    @EmbeddedId
    private ArretCovoitId arretsCovoitId;

    private double tarif;

    @ManyToOne
    private LieuCovoiturage lieuCovoiturage;

    private Boolean estDepart ;


}
