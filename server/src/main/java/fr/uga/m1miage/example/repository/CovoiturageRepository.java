package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.Covoiturage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CovoiturageRepository extends JpaRepository<Covoiturage,Long> {

    Covoiturage deleteCovoiturageByIdCovoiturage(final Long covoiturageId) ;

    List<Covoiturage> getAllByFestival(long festivalId);

}
