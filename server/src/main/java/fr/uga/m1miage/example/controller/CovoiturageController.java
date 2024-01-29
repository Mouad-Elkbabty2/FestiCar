package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.CovoiturageEndPoint;
import fr.uga.m1miage.example.models.Covoiturage;
import fr.uga.m1miage.example.response.CovoiturageDTO;
import fr.uga.m1miage.example.service.CovoiturageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintValidatorContext;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CovoiturageController implements CovoiturageEndPoint {

    private final CovoiturageService covoiturageService;
    @Override
    public List<String> GetModeleVoiture() {
        return covoiturageService.getModeleVoiture();
    }

    @Override
    public List<CovoiturageDTO> getCovoiturageByFestivalId(Long id, int numPage, int taillePage) {
        Pageable pageable = PageRequest.of(numPage,taillePage);
        return covoiturageService.getCovoiturageByFestivalId(id,pageable);
    }
}
