package fr.uga.m1miage.example.controller;


import fr.uga.m1miage.example.endpoint.PanierEndPoint;
import fr.uga.m1miage.example.service.PanierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PanierController implements PanierEndPoint {
    private final PanierService panierService ;
    @Override
    public void deletePanier(long id) {
        panierService.deletePanier(id);
    }
}
