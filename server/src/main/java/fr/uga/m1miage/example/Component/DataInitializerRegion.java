package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.service.RegionDataLoading;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializerRegion implements CommandLineRunner {
    private final RegionDataLoading regionDataLoading;


    @Value("#{'${chemins.vers.csv}'.split(',')}")
    private List<String> cheminsVersCSV;

    public DataInitializerRegion(RegionDataLoading regionDataLoading) {
        this.regionDataLoading = regionDataLoading;
    }
    @Override
    public void run(String... args) {
        for (String cheminVersCSV : cheminsVersCSV) {
            regionDataLoading.chargerDonneesDepuisCSV(cheminVersCSV);
        }
    }
}
