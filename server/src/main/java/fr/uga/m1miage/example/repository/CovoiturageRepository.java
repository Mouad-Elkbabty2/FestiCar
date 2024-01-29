package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Covoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovoiturageRepository extends JpaRepository<Covoiturage, Long> {
    @Query(nativeQuery = true, value = "select distinct MODEL_VOITURE from COVOITURAGE")
    List<String> getModeleVoiture();

}
