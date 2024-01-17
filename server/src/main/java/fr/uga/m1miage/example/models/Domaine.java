package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Domaine {

    @Id
    private String nomDomaine ;
    private String sousDomaine ;
    @ManyToOne
    private Festival festival ;

}
