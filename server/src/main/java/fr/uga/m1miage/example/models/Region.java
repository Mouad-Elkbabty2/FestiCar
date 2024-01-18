package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    private String nomRegion;

    @OneToMany(mappedBy = "nomRegion")
    @NotNull
    private List<Departement> departementList;
}
