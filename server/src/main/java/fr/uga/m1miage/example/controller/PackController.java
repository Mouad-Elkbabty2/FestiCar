package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.PackEndPoint;
import fr.uga.m1miage.example.error.EntityNotFound;
import fr.uga.m1miage.example.request.CreatePackRequest;
import fr.uga.m1miage.example.response.PackDTO;
import fr.uga.m1miage.example.service.PackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class PackController implements PackEndPoint {

    private final PackService packService;
    @Override
    public PackDTO createPack(CreatePackRequest createPackRequest) throws EntityNotFound {
        return packService.createPack(createPackRequest);
    }
}