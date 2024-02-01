package fr.uga.m1miage.example.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArretCovoiturageIdDTO {
    private String horaire;
    private CovoiturageDTO idCovoiturage;
}
