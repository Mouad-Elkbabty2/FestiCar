package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    void deleteUtilisateurById(final long utilisateurId) ;
    Utilisateur getUtilisateurById(final long id ) ;
}
