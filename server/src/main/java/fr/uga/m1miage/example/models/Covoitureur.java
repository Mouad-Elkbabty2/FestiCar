package fr.uga.m1miage.example.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Covoitureur extends Utilisateur{

    @OneToMany(mappedBy = "covoitureur")
    private List<Covoiturage> covoiturageList ;

}
