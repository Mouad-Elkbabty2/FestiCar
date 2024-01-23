package fr.uga.m1miage.example.repository;


import fr.uga.m1miage.example.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,String> {


}
