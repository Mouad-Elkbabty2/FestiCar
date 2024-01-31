package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.ArretCovoitId;
import fr.uga.m1miage.example.models.ArretCovoiturage;
import fr.uga.m1miage.example.response.ArretCovoiturageDTO;
import fr.uga.m1miage.example.response.ArretCovoiturageIdDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ArretCovoitRepository extends JpaRepository<ArretCovoiturage, ArretCovoitId> {
    void deleteByarretsCovoitId(ArretCovoitId arretsCovoitId);



    ArretCovoiturage getArretCovoiturageByArretsCovoitId(ArretCovoitId arretCovoiturageIdDTO);

}
