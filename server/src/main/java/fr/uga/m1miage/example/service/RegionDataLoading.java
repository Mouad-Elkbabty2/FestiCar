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
    private final CommuneRepository communeRepository;

    public void chargerDonneesDepuisCSV(String cheminVersCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(cheminVersCSV))) {
            List<String[]> donnees = reader.readAll();
            for (String[] ligne : donnees) {
                LieuCovoiturage lieuCovoiturage = new LieuCovoiturage();
                lieuCovoiturage.setIdLieu(ligne[0]);
                lieuCovoiturage.setNomLieu(ligne[1]);
                switch (ligne[2]) {
                    case "Parking":
                        lieuCovoiturage.setTypeLieu(TypeLieu.PARKING);
                        break;
                    case "Auto-stop":
                        lieuCovoiturage.setTypeLieu(TypeLieu.AUTO_STOP);
                        break;
                    case "Aire de covoiturage":
                        lieuCovoiturage.setTypeLieu(TypeLieu.AIRE_DE_COVOITURAGE);
                        break;
                    case "Supermarché":
                        lieuCovoiturage.setTypeLieu(TypeLieu.SUPERMARCHE);
                        break;
                    case "Sortie d'autoroute":
                        lieuCovoiturage.setTypeLieu(TypeLieu.SORTIE_AUTOROUTE);
                        break;
                    case "Parking relais":
                        lieuCovoiturage.setTypeLieu(TypeLieu.PARKING_RELAIS);
                        break;
                    case "Délaissé routier":
                        lieuCovoiturage.setTypeLieu(TypeLieu.DELAISSE_ROUTIER );
                        break;
                    default:
                        lieuCovoiturage.setTypeLieu(null);
                }
                lieuCovoiturage.setLongitude(Double.parseDouble(ligne[3]));
                lieuCovoiturage.setLatitude(Double.parseDouble(ligne[4]));
                lieuCovoiturage.setCodeInsee(communeRepository.getCommuneByCodeInsee(ligne[5]));
                lieuCovoiturageRepository.save(lieuCovoiturage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
