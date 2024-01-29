package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Festival;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FestivalRepository extends JpaRepository<Festival,Long> {

    long deleteFestivalByIdFestival(final long idFestival) ;

    List<Festival> findAllByCommune(String codeInsee);

    @Query(nativeQuery = true, value = "SELECT * FROM (SELECT * FROM festival ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <= 8")
    List<Festival> getAllFestivals();

    Festival findFestivalByNomFestival(final String festival);

    Festival getFestivalByIdFestival(final long idF);
    @Query("SELECT f FROM Festival f WHERE " +
            "(:nomFestival IS NULL OR LOWER(f.nomFestival) LIKE CONCAT('%', LOWER(:nomFestival), '%')) " +
            "AND (:dateDebut IS NULL OR f.dateDebut = :dateDebut) " +
            "AND (:dateFin IS NULL OR f.dateFin = :dateFin) " +
            "AND (:tarif IS NULL OR f.tarif = :tarif) " +
            "AND (:sousDomaine IS NULL OR LOWER(f.sousDomaine.nomSousDomaine) LIKE CONCAT('%', LOWER(:sousDomaine), '%'))")
    Page<Festival> findFestivalsByCriteria(
            @Param("nomFestival") String nomFestival,
            @Param("dateDebut") String dateDebut,
            @Param("dateFin") String dateFin,
            @Param("tarif") Double tarif,
            @Param("sousDomaine") String sousDomaine,
            Pageable pageable);



}
