package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    void deleteUtilisateurById(final long utilisateurId) ;
    Utilisateur getUtilisateurById(final long id ) ;
    Utilisateur findUtilisateurById(final long id);
    Utilisateur getUtilisateurByEmail(final String mail) ;
    Utilisateur getUtilisateurByTelephone(final String telephone) ;

}
