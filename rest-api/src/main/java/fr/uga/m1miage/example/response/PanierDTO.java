package fr.uga.m1miage.example.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDTO {
    private long idPanier;


    private Date dateCreation;

    private double total;

    private UtilisateurDTO utilisateur ;

    private EtatPanier etat ;
}
