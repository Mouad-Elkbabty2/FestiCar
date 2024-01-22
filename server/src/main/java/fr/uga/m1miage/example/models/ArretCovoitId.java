package fr.uga.m1miage.example.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
@Data
public class ArretCovoitId implements Serializable {

    @Column(name = "horaire")
    private String horaire;

    @ManyToOne
    @JoinColumn(name = "lieuCovoiturage")
    private LieuCovoiturage lieuCovoiturage;
}