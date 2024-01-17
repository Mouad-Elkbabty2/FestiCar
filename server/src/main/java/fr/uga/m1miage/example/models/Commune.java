package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commune {

    @Id
    private int codeInsee ;

    private String nomCommune ;

    private double longitude ;
    private double latitude ;

}
