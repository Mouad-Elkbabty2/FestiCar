package fr.uga.m1miage.example.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PackDTO {

    private PackIdDTO idPack;

    private int nbPlacesReserves;
}
