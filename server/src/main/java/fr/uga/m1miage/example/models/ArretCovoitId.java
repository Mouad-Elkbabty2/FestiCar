package fr.uga.m1miage.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArretCovoitId implements Serializable {

    @Column(name = "horaire")
    private String horaire;

    @ManyToOne
    @JoinColumn(name = "idCovoiturage")
    private Covoiturage idCovoiturage;


}
