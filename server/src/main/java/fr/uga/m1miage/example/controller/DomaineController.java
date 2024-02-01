package fr.uga.m1miage.example.controller;


import fr.uga.m1miage.example.endpoint.DomaineEndPoint;
import fr.uga.m1miage.example.response.DomaineDTO;
import fr.uga.m1miage.example.service.DomaineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class DomaineController implements DomaineEndPoint {
    private final DomaineService domaineService ;

    @Override
    public List<DomaineDTO> getAllDomains() {
        return domaineService.getAllDomaines();
    }
}
