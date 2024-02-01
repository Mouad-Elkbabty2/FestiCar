package fr.uga.m1miage.example.controller;


import fr.uga.m1miage.example.endpoint.PanierEndPoint;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import fr.uga.m1miage.example.service.PanierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PanierController implements PanierEndPoint {
    private final PanierService panierService ;
    @Override
    public void deletePanier(long id) {
        panierService.deletePanier(id);
    }

    @Override
    public PanierDTO createPanier(long utilisateurId, CreatePanierRequest createPanierRequest)  {
        return panierService.createPanier(utilisateurId,createPanierRequest);
    }

    @Override
    public PanierDTO getPanierById(Long id) {
        return panierService.getPanier(id);
    }

    @Override
    public List<PanierDTO> getPanierByUtilisateur(long utilisateurId) {
        return panierService.getPanierByUtilisateurId(utilisateurId);
    }

  /*  @Override
    public void setPanierUser(long panierId, long userId) {
        panierService.setPanierUser(panierId,userId);
    }*/


}
