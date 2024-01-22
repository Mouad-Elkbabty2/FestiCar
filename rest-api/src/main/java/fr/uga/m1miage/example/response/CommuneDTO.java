package fr.uga.m1miage.example.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CommuneDTO {
    private int codeInsee;

    private String nomCommune;

    private double longitude;
    private double latitude;

/*
    private Departement departement;
*/

    private List<FestivalDTO> festivalDTOListList ;
}
