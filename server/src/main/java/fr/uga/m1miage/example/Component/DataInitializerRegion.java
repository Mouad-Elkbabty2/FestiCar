package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.service.RegionDataLoading;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializerRegion  {
    private final RegionDataLoading regionDataLoading;


    @Value("#{'${chemins.vers.csv}'.split(',')}")
    private List<String> cheminsVersCSV;

    public DataInitializerRegion(RegionDataLoading regionDataLoading) {
        this.regionDataLoading = regionDataLoading;
    }

}
