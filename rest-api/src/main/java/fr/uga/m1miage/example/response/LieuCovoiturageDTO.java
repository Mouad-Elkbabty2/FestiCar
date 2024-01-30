package fr.uga.m1miage.example.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LieuCovoiturageDTO {
    private String idLieu ;
    private String nomLieu ;

    private TypeLieuDTO typeLieu ;


    private CommuneDTO codeInsee ;

    private double longitude ;
    private double latitude ;
}
