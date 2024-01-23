package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String nom ;
    private String prenom ;
    private String telephone ;
    private String email ;
    private String mdp ;

    @OneToMany(mappedBy = "utilisateur")
    private List<Panier> panier ;
    @Enumerated(EnumType.ORDINAL)
    private TypeUtilisateur typeUtilisateur ;
}
