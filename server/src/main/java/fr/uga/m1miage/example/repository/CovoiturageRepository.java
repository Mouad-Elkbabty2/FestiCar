package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Covoiturage;
import fr.uga.m1miage.example.models.Festival;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovoiturageRepository extends JpaRepository<Covoiturage, Long> {
    @Query(nativeQuery = true, value = "select distinct MODEL_VOITURE from COVOITURAGE")
    List<String> getModeleVoiture();

    Page<Covoiturage> getCovoiturageByFestival (Festival id, Pageable pageable);

/*    @Query("SELECT c FROM Covoiturage c WHERE " +
            "(:villeDepart IS NULL OR LOWER(c.villeDepart) LIKE CONCAT('%', LOWER(:villeDepart), '%')) " +
            "AND (:typeVehicule IS NULL OR LOWER(c.modelVoiture) LIKE CONCAT('%', LOWER(:typeVehicule), '%')) " +
            "AND (:placesDispo IS NULL OR c.placesDispo >= :placesDispo) " +
            "AND (:budget IS NULL OR c.budget <= :budget)")
    Page<Covoiturage> filterCovoiturages(
            String villeDepart,
            String typeVehicule,
            Integer placesDispo,
            Double budget,
            Pageable pageable);*/


}
