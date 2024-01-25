package fr.uga.m1miage.example.request;


import fr.uga.m1miage.example.response.EtatPanier;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Panier")
public class CreatePanierRequest {
    private long idPanier;


    private Date dateCreation;

    private double total;

    private UtilisateurDTO utilisateur ;

    private EtatPanier etat ;
}
