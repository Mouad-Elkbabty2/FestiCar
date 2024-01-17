package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organisateur extends Utilisateur{
    private long idManifestation ;
}
