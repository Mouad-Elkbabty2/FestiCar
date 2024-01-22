package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PanierRepository extends JpaRepository<Panier,Long> {

    long deletePanierById(long idPanier);

    Panier getAllByUtilisateur(Utilisateur utilisateur) ;

}
