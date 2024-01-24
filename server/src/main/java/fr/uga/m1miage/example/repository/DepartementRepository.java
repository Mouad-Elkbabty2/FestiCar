package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, String> {

}
