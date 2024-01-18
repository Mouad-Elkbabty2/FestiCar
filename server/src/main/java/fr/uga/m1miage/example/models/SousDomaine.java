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
public class SousDomaine {

    @Id
    private String nomSousDomaine;

    @ManyToOne
    @JoinColumn(name = "nomDomaine")

    private Domaine domaine;

    @OneToMany(mappedBy = "sousDomaine")
    private List<Festival> festivalList;
}
