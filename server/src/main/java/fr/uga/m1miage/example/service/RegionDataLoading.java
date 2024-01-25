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

    private final UtilisateurRepository utilisateurRepository;

    public void chargerDonneesDepuisCSV(String cheminVersCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(cheminVersCSV))) {
            List<String[]> donnees = reader.readAll();
            for (String[] ligne : donnees) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(ligne[0]);
                utilisateur.setPrenom(ligne[1]);
                utilisateur.setTelephone(ligne[2]);
                utilisateur.setEmail(ligne[3]);
                utilisateur.setMdp(ligne[4]);
                if(Integer.parseInt(ligne[5])== 0){
                    utilisateur.setTypeUtilisateur(TypeUtilisateur.PASSAGER);
                }else{
                    utilisateur.setTypeUtilisateur(TypeUtilisateur.CONDUCTEUR);
                }
                utilisateurRepository.save(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
