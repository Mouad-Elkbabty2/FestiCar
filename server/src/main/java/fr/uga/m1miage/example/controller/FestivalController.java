package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.endpoint.FestivalEndPoint;
import fr.uga.m1miage.example.response.FestivalDTO;
import fr.uga.m1miage.example.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
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
    public List<FestivalDTO> getFestivalsByCriteria(String nomFestival, String dateDebut, String dateFin, Double tarif, String sousDomaine) {
        return festivalService.getAllFestivalsByCriteria(nomFestival,
                                                        dateDebut,
                                                        dateFin,
                                                        tarif,
                                                        sousDomaine);
    }

    @Override
    public FestivalDTO getFestivalById(Long id) {
        return festivalService.getFestivalById(id);
    }
}
