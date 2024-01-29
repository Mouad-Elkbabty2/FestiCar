package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.FestivalEndPoint;
import fr.uga.m1miage.example.response.FestivalDTO;
import fr.uga.m1miage.example.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class FestivalController implements FestivalEndPoint {
    private final FestivalService festivalService;
    @Override
    public List<FestivalDTO> getAllFestivals() {
        return festivalService.getAllFestivals();
    }



    @Override
    public List<FestivalDTO> getFestivalsByCriteria(String nomFestival, String dateDebut, String dateFin, Double tarif, String sousDomaine,int numPage , int taille) {
        Pageable pageable = PageRequest.of(numPage, taille);


        return festivalService.getAllFestivalsByCriteria(nomFestival,
                                                        dateDebut,
                                                        dateFin,
                                                        tarif,
                                                        sousDomaine,pageable);
    }

    @Override
    public FestivalDTO getFestivalById(Long id) {
        return festivalService.getFestivalById(id);
    }


}
