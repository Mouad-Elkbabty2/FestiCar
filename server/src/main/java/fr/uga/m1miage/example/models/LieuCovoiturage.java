package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.*;

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

    @Column(name="Insee")
    private int codeInsee ;
    // type Lieu
}
