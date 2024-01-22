package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Data
@NoArgsConstructor
public class ArretCovoiturage {

    @EmbeddedId
    private ArretCovoitId arretsCovoitId;

    private double tarif;



}