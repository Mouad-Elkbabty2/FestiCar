package fr.uga.m1miage.example.models;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class ArretCovoitId implements Serializable {


    private String horaire ;
    private long idCovoiturage ;
}
