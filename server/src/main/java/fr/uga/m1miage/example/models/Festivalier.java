package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.Entity;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Festivalier extends Utilisateur{
    private long idCoiturage ;
}
