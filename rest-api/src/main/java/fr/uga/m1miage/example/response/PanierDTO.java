package fr.uga.m1miage.example.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Builder
@Data

public class PanierDTO {
    private long idPanier;


    private Date dateCreation;

    private double total;

    @JsonIgnore
    private UtilisateurDTO utilisateur ;

    private EtatPanier etat ;
}
