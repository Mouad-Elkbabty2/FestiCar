package fr.uga.m1miage.example.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Festival")
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFestival;

    private String nomFestival;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    private long tarif;

    private double longitude;

    private double latitude;

    private int nbPlace;
    private int nbPlacesVendues ;

    private int nbPlacesDisponible;

    @ManyToOne
    private SousDomaine sousDomaine ;

}
