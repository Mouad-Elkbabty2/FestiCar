package fr.uga.m1miage.example.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartementDTO {
    private int numDepartement;

    private String nomDepartement;

    private RegionDTO nomRegion;
}
