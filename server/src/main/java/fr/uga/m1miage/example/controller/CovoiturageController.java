package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.CovoiturageEndPoint;
import fr.uga.m1miage.example.response.CovoiturageDTO;
import fr.uga.m1miage.example.service.CovoiturageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CovoiturageController implements CovoiturageEndPoint {

    private final CovoiturageService covoiturageService;
    @Override
    public List<String> getModeleVoiture() {
        return covoiturageService.getModeleVoiture();
    }

    @Override
    public CovoiturageDTO getCovoiturageById(long covoiturageId) {
        return covoiturageService.getCovoiturageById(covoiturageId);
    }

    @Override
    public List<CovoiturageDTO> getCovoiturageByFestivalId(Long id, int numPage, int taillePage) {
        Pageable pageable = PageRequest.of(numPage,taillePage);
        return covoiturageService.getCovoiturageByFestivalId(id,pageable);
    }

    @Override
    public List<CovoiturageDTO> filterCovoiturages(String nomCommune,
                                                   String modelVoiture,
                                                   Integer placesDispo,
                                                   Double budget,
                                                   int numPage , int taille,long festivalId) {
        Pageable pageable = PageRequest.of(numPage, taille);

        return covoiturageService.filterCovoiurage(nomCommune,
                modelVoiture,
                placesDispo,
                budget,
               pageable, festivalId);
    }
}
