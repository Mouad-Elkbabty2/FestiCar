package fr.uga.m1miage.example.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
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

/*    @JsonIgnore
    private List<CovoiturageDTO> covoiturageList ;*/

    private CommuneDTO commune ;
}
