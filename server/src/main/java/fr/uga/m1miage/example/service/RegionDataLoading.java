package fr.uga.m1miage.example.service;

import com.opencsv.CSVReader;
import fr.uga.m1miage.example.models.Departement;
import fr.uga.m1miage.example.models.Domaine;
import fr.uga.m1miage.example.models.Region;
import fr.uga.m1miage.example.models.SousDomaine;
import fr.uga.m1miage.example.repository.DepartementRepository;
import fr.uga.m1miage.example.repository.DomaineRepository;
import fr.uga.m1miage.example.repository.RegionRepository;
import fr.uga.m1miage.example.repository.SousDomaineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
@AllArgsConstructor
public class RegionDataLoading {


    private final DepartementRepository departementRepository;
    private final RegionRepository regionRepository;


    public void chargerDonneesDepuisCSV(String cheminVersCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(cheminVersCSV))) {
            List<String[]> donnees = reader.readAll();

            for (String[] ligne : donnees) {
                Departement departement = new Departement();
                departement.setNumDepartement(ligne[0]);
                departement.setNomDepartement(ligne[1]);
                departement.setNomRegion(regionRepository.getRegionByNomRegion(ligne[2]));
                departementRepository.save(departement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
