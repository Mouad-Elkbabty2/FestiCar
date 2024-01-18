package fr.uga.m1miage.example.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ArretCovoitId implements Serializable {

    @Column(name = "horaire")
    private String horaire;

    @ManyToOne
    @JoinColumn(name = "idCovoiturage")
    private Covoiturage idCovoiturage;
}
