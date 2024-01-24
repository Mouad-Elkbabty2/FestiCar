package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id
    private String numDepartement;

    private String nomDepartement;

    @ManyToOne
    @JoinColumn(name = "nomRegion")
    private Region nomRegion;


}
