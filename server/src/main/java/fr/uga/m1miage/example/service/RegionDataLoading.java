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

    private final CovoiturageRepository covoiturageRepository;
    private final FestivalRepository festivalRepository;
    private final UtilisateurRepository utilisateurRepository;

    public void chargerDonneesDepuisCSV(String cheminVersCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(cheminVersCSV))) {
            List<String[]> donnees = reader.readAll();
            for (String[] ligne : donnees) {
                Covoiturage covoiturage = new Covoiturage();
                covoiturage.setUtilisateur(utilisateurRepository.getUtilisateurById(Long.parseLong(ligne[0])));
                covoiturage.setFestival(festivalRepository.getFestivalByIdFestival(Long.parseLong(ligne[1])));
                covoiturage.setTarif(Double.parseDouble(ligne[2]));
                covoiturage.setMarque(ligne[3]);
                covoiturage.setModelVoiture(ligne[4]);
                covoiturage.setNbPlaces(Integer.parseInt(ligne[5]));
                covoiturage.setNbPlacesReservées(Integer.parseInt(ligne[6]));
                covoiturage.setCouleur(ligne[7]);
                covoiturageRepository.save(covoiturage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
