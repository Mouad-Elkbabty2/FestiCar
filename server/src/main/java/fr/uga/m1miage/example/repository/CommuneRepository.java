package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Integer> {
    Commune getCommuneByCodeInsee(String codeInsee);
}
