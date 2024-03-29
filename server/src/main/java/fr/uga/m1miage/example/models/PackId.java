package fr.uga.m1miage.example.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.*;

@Data
@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PackId implements Serializable {


    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "horaire", referencedColumnName = "horaire"),
            @JoinColumn(name = "idCovoiturage", referencedColumnName = "idCovoiturage")
    })
    private ArretCovoiturage arretCovoiturage;

}
