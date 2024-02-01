package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.PackEndPoint;
import fr.uga.m1miage.example.request.CreatePackRequest;
import fr.uga.m1miage.example.response.PackDTO;
import fr.uga.m1miage.example.service.PackService;
import fr.uga.m1miage.example.service.PanierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class PackController implements PackEndPoint {

    private final PackService packService;
    private final PanierService panierService ;
    @Override
    public PackDTO createPack(CreatePackRequest createPackRequest)  {
        return packService.createPack(createPackRequest);
    }

    @Override
    public PackDTO updateNbPlaces(CreatePackRequest request) {
        return packService.updatePack(request);
    }

    @Override
    public List<PackDTO> getAllPackByPanierId(long panierId) {
        return packService.getAllByIdPanier(panierId);
    }

    @Override
    public void setPanierUser(long panierId, long userId) {
        panierService.setPanierUser(panierId,userId);
    }

}
