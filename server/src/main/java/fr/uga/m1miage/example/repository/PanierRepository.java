package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface PanierRepository extends JpaRepository<Panier,Long> {

    void deleteById(final long id);
    List<Panier> getAllByUtilisateurId(final long utilisateurId) ;
    Panier findPanierByIdPanier(final long idPanier);

}
