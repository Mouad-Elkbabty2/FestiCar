package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    void deleteUtilisateurById(final long utilisateurId) ;
    Utilisateur getUtilisateurById(final long id ) ;
    Utilisateur findUtilisateurById(final long id);
    Utilisateur getUtilisateurByEmail(final String mail) ;
    Utilisateur getUtilisateurByTelephone(final String telephone) ;

    @Query(nativeQuery = false,value="select c from Panier c where c.utilisateur.id = :utilisateurId ")
    List<Panier> getPanierByUtilisateurId(long utilisateurId);

}
