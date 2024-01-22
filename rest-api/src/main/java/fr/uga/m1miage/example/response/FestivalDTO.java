package fr.uga.m1miage.example.response;


import lombok.Builder;
import lombok.Data;

import java.sql.Date;


@Data
@Builder
public class FestivalDTO {
    private long idFestival;

    private String nomFestival;

    private Date dateDebut;

    private Date dateFin;

    private double tarif;

    private double longitude;

    private double latitude;

    private int nbPlace;
    private int nbPlacesVendues;

    private int nbPlacesDisponible;

/*    private SousDomaineDTO sousDomaine;

    private List<CovoiturageDTO> covoiturageList ;

    private CommuneDTO commune ;*/
}
