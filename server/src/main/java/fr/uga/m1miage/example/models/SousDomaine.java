package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SousDomaine {

    @Id
    private String nomSousDomaine;

    @ManyToOne
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;

}
