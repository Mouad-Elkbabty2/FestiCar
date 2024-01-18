package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SousDomaine {

    @Id
    private String nomSousDomaine;

    @ManyToOne
    private Domaine domaine;

    @OneToMany(mappedBy = "sousDomaine")
    private List<Festival> festivalList;
}
