package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LieuCovoiturage {

    @Id
    private String idLieu ;
    private String nomLieu ;

    @Enumerated(EnumType.ORDINAL)
    private TypeLieu typeLieu ;

    @ManyToOne
    @JoinColumn(name="codeInsee")
    private Commune codeInsee ;

    private double longitude ;
    private double latitude ;

}
