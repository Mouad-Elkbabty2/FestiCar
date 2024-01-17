package fr.uga.m1miage.example.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Data
public class OffreId implements Serializable {

    private long idFestival;
    private long idCovoiturage;
}
