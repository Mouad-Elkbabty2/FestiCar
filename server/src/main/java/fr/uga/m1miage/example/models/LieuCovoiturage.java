package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LieuCovoiturage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLieu ;

    private String nomLieu ;

    private String adresseLieu ;

    private int codeInsee ;


    private double longitude ;
    private double latitude ;
}
