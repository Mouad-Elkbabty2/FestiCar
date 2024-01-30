package fr.uga.m1miage.example.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArretCovoiturageDTO {

    ArretCovoiturageIdDTO arretCovoiturageId;

    private double tarif;

    private  LieuCovoiturageDTO lieuCovoiturage;

    private Boolean estDepart ;
}
