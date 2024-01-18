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
public class Domaine {

    @Id
    private String nomDomaine;

    @OneToMany(mappedBy = "domaine")
    private List<SousDomaine> sousDomaine;
    @ManyToOne
    @JoinColumn(name = "idFestival")

    private Festival festival;

}
