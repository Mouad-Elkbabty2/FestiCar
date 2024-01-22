package fr.uga.m1miage.example.repository;

import fr.uga.m1miage.example.models.ArretCovoitId;
import fr.uga.m1miage.example.models.ArretCovoiturage;
import fr.uga.m1miage.example.models.LieuCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArretCovoitRepository extends JpaRepository<ArretCovoiturage, ArretCovoitId> {
    void deleteByarretsCovoitId(ArretCovoitId arretsCovoitId);
}
