package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Pack;
import fr.uga.m1miage.example.models.PackId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface PackRepository extends JpaRepository<Pack, PackId> {

                Pack getPackByIdPack(PackId packId);
                @Query("SELECT c From Pack c where c.idPack.panier.idPanier = :idPanier")
                List<Pack> getAllByIdPanier(long idPanier);
}
