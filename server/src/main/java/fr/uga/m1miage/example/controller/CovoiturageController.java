package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.CovoiturageEndPoint;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.service.CovoiturageService;
import lombok.RequiredArgsConstructor;
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
}
