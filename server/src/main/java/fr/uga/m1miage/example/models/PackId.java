package fr.uga.m1miage.example.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Embeddable
public class PackId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idFestival")
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "horaire", referencedColumnName = "horaire"),
            @JoinColumn(name = "lieuCovoiturage", referencedColumnName = "lieuCovoiturage")
    })
    private ArretCovoiturage arretCovoiturage;
}
