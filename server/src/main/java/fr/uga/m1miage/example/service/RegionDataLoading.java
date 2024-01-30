package fr.uga.m1miage.example.service;

import com.opencsv.CSVReader;
import fr.uga.m1miage.example.models.*;
import fr.uga.m1miage.example.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
@AllArgsConstructor
public class RegionDataLoading {

    private final LieuCovoiturageRepository lieuCovoiturageRepository;
    private final ArretCovoitRepository arretCovoitRepository;
    private final CovoiturageRepository covoiturageRepository;

    public void chargerDonneesDepuisCSV(String cheminVersCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(cheminVersCSV))) {
            List<String[]> donnees = reader.readAll();
            for (String[] ligne : donnees) {
                ArretCovoiturage arretCovoiturage = new ArretCovoiturage();
                arretCovoiturage.setArretsCovoitId(new ArretCovoitId(ligne[0],covoiturageRepository.getCovoiturageByIdCovoiturage(Long.parseLong(ligne[2]))));
                arretCovoiturage.setTarif(Double.parseDouble(ligne[1]));
                arretCovoiturage.setLieuCovoiturage(lieuCovoiturageRepository.getLieuCovoiturageByIdLieu(ligne[3]));
                if(Integer.parseInt(ligne[4]) == 1){
                    arretCovoiturage.setEstDepart(true);
                }else{
                    arretCovoiturage.setEstDepart(false);
                }
                arretCovoitRepository.save(arretCovoiturage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
