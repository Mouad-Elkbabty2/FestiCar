package fr.uga.m1miage.example.response;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class UtilisateurDTO {
    private long id ;

    private String nom ;
    private String prenom ;
    private String telephone ;
    private String email ;
    private String mdp ;


    private TypeUtilisateur typeUtilisateur ;
}
