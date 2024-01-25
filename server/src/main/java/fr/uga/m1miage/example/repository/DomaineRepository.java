package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, String> {
    Domaine getDomaineByNomDomaine(String nomDomaine);

    @Query(nativeQuery = true, value = "Select * from Domaine")
    List<Domaine> getAllDomaines();
}
