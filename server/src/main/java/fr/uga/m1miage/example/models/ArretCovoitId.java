package fr.uga.m1miage.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArretCovoitId implements Serializable {

    private String horaire;

    @ManyToOne
    @JoinColumn(name = "idCovoiturage")
    private Covoiturage idCovoiturage;


}
