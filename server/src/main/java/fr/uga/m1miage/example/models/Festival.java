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

    @Column
    private String nomFestival;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    @Column
    private long tarif;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @Column
    private int nbPlace;


}
