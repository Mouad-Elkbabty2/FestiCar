package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FestivalRepository extends JpaRepository<Festival,Long> {

    long deleteFestivalByIdFestival(final long idFestival) ;

    List<Festival> findAllByCommune(int codeInsee);
    List<Festival> getAllFestivals();

    Festival findFestivalByNomFestival(final String festival);

}
