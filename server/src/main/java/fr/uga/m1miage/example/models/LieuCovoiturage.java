package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Column(name="adresse")
    private String adresseLieu ;

    @Column(name="insee")
    private int codeInsee ;

    @ManyToMany
    private List<Covoiturage> covoiturageList ;

    private double longitude ;
    private double latitude ;
}
