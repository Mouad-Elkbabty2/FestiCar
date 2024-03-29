package fr.uga.m1miage.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPanier;

    @JsonFormat(pattern = "yyyy-MM-dd")

    private Date dateCreation;

    private double total;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur ;

    @Enumerated(EnumType.ORDINAL)
    private EtatPanier etat ;

}
