package fr.uga.m1miage.example.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(unique = true)
    private String telephone ;
    @Column(unique = true)

    private String email ;
    private String mdp ;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private List<Panier> panier ;
    @Enumerated(EnumType.ORDINAL)
    private TypeUtilisateur typeUtilisateur ;
}
