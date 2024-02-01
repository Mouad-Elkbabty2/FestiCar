package fr.uga.m1miage.example.request;

import fr.uga.m1miage.example.response.PanierDTO;
import fr.uga.m1miage.example.response.TypeUtilisateur;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Utilisateur")
@AllArgsConstructor
@NoArgsConstructor
public class CreateUtilisateurRequest {
    private long id ;

    private String nom ;
    private String prenom ;
    private String telephone ;
    private String email ;
    private String mdp ;

    private TypeUtilisateur typeUtilisateur ;

}
