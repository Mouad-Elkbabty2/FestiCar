package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Pack;
import fr.uga.m1miage.example.models.PackId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface PackRepository extends JpaRepository<Pack, PackId> {


}
