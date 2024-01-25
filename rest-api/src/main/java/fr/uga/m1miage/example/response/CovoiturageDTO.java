package fr.uga.m1miage.example.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CovoiturageDTO {
    private long idCovoiturage;

    private int nbPlaces;

    private double tarif;

    private String modelVoiture;
    private String couleur ;
    private String marque ;

/*    private UtilisateurDTO utilisateur ;*/
    private FestivalDTO festival ;
    private int nbPlacesReservées ;

}
