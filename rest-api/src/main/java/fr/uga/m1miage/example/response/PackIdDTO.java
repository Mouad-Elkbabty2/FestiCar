package fr.uga.m1miage.example.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PackIdDTO {

    private PanierDTO panier;

    private ArretCovoiturageDTO arretCovoiturage;
}
