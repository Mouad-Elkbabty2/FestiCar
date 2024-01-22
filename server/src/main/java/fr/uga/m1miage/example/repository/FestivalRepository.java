package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivalRepository extends JpaRepository<Festival,Long> {

    long deleteFestivalByIdFestival(final long idFestival) ;

    List<Festival> findAllByCommune(int codeInsee);
}
