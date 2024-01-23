package fr.uga.m1miage.example.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    private String nomRegion;


}
