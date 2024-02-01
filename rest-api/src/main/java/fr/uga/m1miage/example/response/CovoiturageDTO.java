package fr.uga.m1miage.example.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CovoiturageDTO {
    private long idCovoiturage;


    private int nbPlaces;

    private double tarif;

    private String modelVoiture;
    private String couleur ;
    private String marque ;

    private UtilisateurDTO utilisateur ;
    private FestivalDTO festival ;
    private int nbPlacesReservées ;
    private List<ArretCovoiturageDTO> arretCovoiturageList;


}
