package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.CommuneEndPoint;
import fr.uga.m1miage.example.response.CommuneDTO;
import fr.uga.m1miage.example.service.CommuneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CommuneController implements CommuneEndPoint {
    private final CommuneService communeService ;
    @Override
    public List<CommuneDTO> getAllCommunes() {
        return communeService.getAllDomaines();
    }
}
