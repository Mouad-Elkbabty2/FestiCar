package fr.uga.m1miage.example.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Festivalier extends Utilisateur{


    @ManyToMany
    @JsonIgnore
    private List<Covoiturage> covoiturageList ;

}
