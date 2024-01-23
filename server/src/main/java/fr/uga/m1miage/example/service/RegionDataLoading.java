package fr.uga.m1miage.example.service;

import com.opencsv.CSVReader;
import fr.uga.m1miage.example.models.Region;
import fr.uga.m1miage.example.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class RegionDataLoading {


    private final RegionRepository regionRepository;

    public RegionDataLoading(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public void chargerDonneesDepuisCSV(String cheminVersCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(cheminVersCSV))) {
            List<String[]> donnees = reader.readAll();

            for (String[] ligne : donnees) {
                Region region = new Region();
                region.setNomRegion(ligne[0]);
                regionRepository.save(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
