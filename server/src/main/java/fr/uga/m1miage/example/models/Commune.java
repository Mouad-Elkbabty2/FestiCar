package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commune {

    @Id
    private String codeInsee;

    private String nomCommune;

    private double longitude;
    private double latitude;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToMany(mappedBy = "commune")
    private List<Festival> festivalList ;
}
