package fr.uga.m1miage.example.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FestivalDTO {
    private long idFestival;

    private String nomFestival;

    private String dateDebut;

    private String dateFin;

    private double tarif;

    private double longitude;

    private double latitude;

    private int nbPlace;
    private int nbPlacesVendues;

    private int nbPlacesDisponible;

    private SousDomaineDTO sousDomaine;

    private CommuneDTO commune ;
}
