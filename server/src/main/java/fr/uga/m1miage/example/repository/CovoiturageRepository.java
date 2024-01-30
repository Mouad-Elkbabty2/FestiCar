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


    Covoiturage getCovoiturageByIdCovoiturage(long idCovoiturage);

    @Query("SELECT c.arretsCovoitId.idCovoiturage FROM ArretCovoiturage c WHERE " +
            " (:nomCommune IS NULL OR LOWER(c.lieuCovoiturage.codeInsee.nomCommune) LIKE CONCAT('%', LOWER(:nomCommune), '%')) " +
            "AND c.estDepart = true  " +
            "AND (:modelVoiture IS NULL OR LOWER(c.arretsCovoitId.idCovoiturage.modelVoiture) LIKE CONCAT('%', LOWER(:modelVoiture), '%')) " +
            "AND (:placesDispo IS NULL OR ((c.arretsCovoitId.idCovoiturage.nbPlaces ) - (c.arretsCovoitId.idCovoiturage.nbPlacesReservées)) >= :placesDispo) " +
            "AND (:budget IS NULL OR c.arretsCovoitId.idCovoiturage.tarif <= :budget)")
    Page<Covoiturage> filterCovoiturages(
            String nomCommune,
            String modelVoiture,
            Integer placesDispo,
            Double budget,
            Pageable pageable);



}
