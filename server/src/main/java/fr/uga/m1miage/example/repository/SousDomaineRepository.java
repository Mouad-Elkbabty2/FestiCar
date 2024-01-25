package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.SousDomaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousDomaineRepository extends JpaRepository<SousDomaine, String> {
    SousDomaine getSousDomaineByNomSousDomaine(String nomSousDomaine);
}
