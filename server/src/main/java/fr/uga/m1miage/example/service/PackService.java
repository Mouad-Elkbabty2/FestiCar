package fr.uga.m1miage.example.service;


import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.PackMapper;
import fr.uga.m1miage.example.models.*;
import fr.uga.m1miage.example.repository.ArretCovoitRepository;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.repository.PackRepository;
import fr.uga.m1miage.example.repository.PanierRepository;
import fr.uga.m1miage.example.request.CreatePackRequest;
import fr.uga.m1miage.example.response.PackDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PackService {

    private final PanierRepository panierRepository ;
    private final PackRepository packRepository;
    private final ArretCovoitRepository arretCovoitRepository ;
    private final CovoiturageRepository covoiturageRepository ;
    private final PackMapper packMapper;


    @SneakyThrows
    @Transactional
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
pack.setNbPlacesReserves(request.getNbPlacesReserves());
        packRepository.save(pack);

        return packMapper.entityToDTO(pack);
    }

    @SneakyThrows
    @Transactional
    public List<PackDTO> getAllByIdPanier(long panierId){
        return packMapper.entityToDTOList(packRepository.getAllByIdPanier(panierId));

    }

    @SneakyThrows
    @Transactional
    public PackDTO updatePack(CreatePackRequest request)  {


        Pack pack = packRepository.getPackByIdPack(request.getHoraire(),request.getIdCovoiturage(),request.getPanier());
    if(pack == null){
        throw new EntityNotFound("Pack not found ");
    }
        pack.setNbPlacesReserves(request.getNbPlacesReserves());
        packRepository.save(pack);
        return packMapper.entityToDTO(pack);
    }
}
