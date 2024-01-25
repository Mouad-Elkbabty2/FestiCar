package fr.uga.m1miage.example.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "sousDomaine_id")
    private SousDomaine sousDomaine;

    @OneToMany(mappedBy = "festival")
    private List<Covoiturage> covoiturageList ;

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune ;

}
