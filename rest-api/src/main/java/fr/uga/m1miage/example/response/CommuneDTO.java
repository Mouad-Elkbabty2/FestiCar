package fr.uga.m1miage.example.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommuneDTO {
    private String codeInsee;

    private String nomCommune;

    private double longitude;
    private double latitude;

    private DepartementDTO departement;

    private List<FestivalDTO> festivalDTOListList ;
}
