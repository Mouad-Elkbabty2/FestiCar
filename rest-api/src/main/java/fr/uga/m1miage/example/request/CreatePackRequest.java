package fr.uga.m1miage.example.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Pack")
public class CreatePackRequest {

    private long panier;

    private String horaire;
    private long idCovoiturage ;

    private int nbPlacesReserves;

}
