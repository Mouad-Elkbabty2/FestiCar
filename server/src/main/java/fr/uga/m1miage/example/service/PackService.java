package fr.uga.m1miage.example.service;


import fr.uga.m1miage.example.mapper.PackMapper;
import fr.uga.m1miage.example.models.*;
import fr.uga.m1miage.example.repository.ArretCovoitRepository;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.repository.PackRepository;
import fr.uga.m1miage.example.repository.PanierRepository;
import fr.uga.m1miage.example.request.CreatePackRequest;
import fr.uga.m1miage.example.response.PackDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor

public class PackService {

    private final PanierRepository panierRepository ;
    private final PackRepository packRepository;
    private final ArretCovoitRepository arretCovoitRepository ;
    private final CovoiturageRepository covoiturageRepository ;
    private final PackMapper packMapper;

    public PackDTO createPack(CreatePackRequest request) {

        Panier panier = panierRepository.findById(request.getPanier())
                .orElseThrow(() -> new EntityNotFoundException("Panier non trouvé avec l'ID : " + request.getPanier()));
        ArretCovoiturage arretCovoiturage = arretCovoitRepository.findById(
                        new ArretCovoitId(request.getHoraire(),
                                covoiturageRepository.findById(request.getIdCovoiturage())
                                        .orElseThrow(() -> new EntityNotFoundException("Covoiturage non trouvé avec l'ID : " + request.getIdCovoiturage()))))
                .orElseThrow(() -> new EntityNotFoundException("Arrêt de covoiturage non trouvé avec l'ID : " + request.getHoraire()));


        Pack pack = new Pack();
        PackId packId = new PackId(panier,arretCovoiturage);
pack.setIdPack(packId);
        packRepository.save(pack);

        return packMapper.entityToDTO(pack);
    }
}