package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface PanierRepository extends JpaRepository<Panier,Long> {

    long deleteById(long id);
    Panier getAllByUtilisateur(Utilisateur utilisateur) ;

}