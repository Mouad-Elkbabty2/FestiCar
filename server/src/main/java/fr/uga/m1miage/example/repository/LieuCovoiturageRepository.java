package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.LieuCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuCovoiturageRepository extends JpaRepository<LieuCovoiturage, String> {

    LieuCovoiturage getLieuCovoiturageByIdLieu(String idLieu);
}
