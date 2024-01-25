package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FestivalRepository extends JpaRepository<Festival,Long> {

    long deleteFestivalByIdFestival(final long idFestival) ;

    List<Festival> findAllByCommune(String codeInsee);

    @Query(nativeQuery = true, value = "SELECT * FROM (SELECT * FROM festival ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <= 8")
    List<Festival> getAllFestivals();

    Festival findFestivalByNomFestival(final String festival);



}
