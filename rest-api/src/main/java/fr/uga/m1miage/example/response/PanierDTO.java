package fr.uga.m1miage.example.response;


import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Builder
@Data

public class PanierDTO {

    private long idPanier;

    private Date dateCreation;

    private double total;

    private UtilisateurDTO utilisateur ;

    private EtatPanier etat ;
}
