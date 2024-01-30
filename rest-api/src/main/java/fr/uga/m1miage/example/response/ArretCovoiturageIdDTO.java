package fr.uga.m1miage.example.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArretCovoiturageIdDTO {
    private String horaire;
    private CovoiturageDTO idCovoiturage;
}
