package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.CovoiturageEndPoint;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.response.CovoiturageDTO;
import fr.uga.m1miage.example.response.FestivalDTO;
import fr.uga.m1miage.example.service.CovoiturageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CovoiturageController implements CovoiturageEndPoint {

    private final CovoiturageService covoiturageService;
    @Override
    public List<String> GetModeleVoiture() {
        return covoiturageService.getModeleVoiture();
    }


/*    @Override
    public List<CovoiturageDTO> filterCovoiturages(String nomFestival, String dateDebut, String dateFin, Double tarif, String sousDomaine) {
        Pageable pageable = PageRequest.of(0, 8);

        return covoiturageService.getAllFestivalsByCriteria(nomFestival,
                dateDebut,
                dateFin,
                tarif,
                sousDomaine,pageable);
    }*/
}
