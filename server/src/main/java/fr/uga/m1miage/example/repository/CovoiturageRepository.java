package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Covoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CovoiturageRepository extends JpaRepository<Covoiturage,Long> {

    Covoiturage deleteCovoiturageByIdCovoiturage(final Long covoiturageId) ;

    List<Covoiturage> getAllByFestival(long festivalId);

}
