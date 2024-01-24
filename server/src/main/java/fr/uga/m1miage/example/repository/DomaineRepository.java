package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, String> {
    Domaine getDomaineByNomDomaine(String nomDomaine);
}
