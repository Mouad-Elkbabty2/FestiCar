package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.CovoiturageComponent;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.ArretCovoiturageMapper;
import fr.uga.m1miage.example.mapper.CovoiturageMapper;
import fr.uga.m1miage.example.models.ArretCovoitId;
import fr.uga.m1miage.example.models.ArretCovoiturage;
import fr.uga.m1miage.example.models.Covoiturage;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.response.ArretCovoiturageDTO;
import fr.uga.m1miage.example.response.ArretCovoiturageIdDTO;
import fr.uga.m1miage.example.response.CovoiturageDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CovoiturageService {
    private final CovoiturageComponent covoiturageComponent;
    private final CovoiturageMapper covoiturageMapper;
    private final CovoiturageRepository covoiturageRepository ;
    private final ArretCovoiturageMapper arretCovoiturageMapper;
    @SneakyThrows
    @Transactional
    public List<String> getModeleVoiture(){return covoiturageComponent.getModeleVoiture();}

    @SneakyThrows
    @Transactional
    public List<CovoiturageDTO> getCovoiturageByFestivalId(Long id, Pageable pageable) {
        try{
            Page<Covoiturage> covoituragesPage = covoiturageComponent.getCovoiturageByFestivalId(id,pageable);
            List<Covoiturage> covoiturages = covoituragesPage.getContent();
            List<CovoiturageDTO> covoitsDTOs =   new ArrayList<>();

            List<ArretCovoiturageDTO> arretCovoiturageDTOList = null ;
            for(Covoiturage co:covoiturages){
                arretCovoiturageDTOList = new ArrayList<>() ;
                CovoiturageDTO covoiturageDTO = covoiturageMapper.entityToDTO(co);
                List<ArretCovoiturage> arretCovoiturageList = co.getArretCovoiturageList();
                for(ArretCovoiturage arretCovoiturage:arretCovoiturageList){
                    ArretCovoitId arretCovoitId = arretCovoiturage.getArretsCovoitId();
                    ArretCovoiturageIdDTO arretCovoiturageIdDTO = arretCovoiturageMapper.entityIdToDTO(arretCovoitId);
                    ArretCovoiturageDTO arretCovoiturageDTO = arretCovoiturageMapper.entityToDTO(arretCovoiturage);
                    arretCovoiturageDTO.setArretCovoiturageId(arretCovoiturageIdDTO);
                    arretCovoiturageDTOList.add(arretCovoiturageDTO);
                }

                covoiturageDTO.setArretCovoiturageList(arretCovoiturageDTOList);
                covoitsDTOs.add(covoiturageDTO);
            }
            return covoitsDTOs;
        }catch(EntityNotFound e){
            throw new EntityNotFound("Aucun ;covoiturage n'existe pour ce festival");
        }
    }

    @SneakyThrows
    @Transactional
    public CovoiturageDTO getCovoiturageById(long idcovoiturage){
        Covoiturage covoiturage = covoiturageRepository.getCovoiturageByIdCovoiturage(idcovoiturage);
        if(covoiturage == null){
            throw new EntityNotFound("Impossible de charger l'entité Covoiturage");

        }
        return covoiturageMapper.entityToDTO(covoiturage);
    }
    @SneakyThrows
    @Transactional
    public List<CovoiturageDTO> filterCovoiurage(String nomCommune,
                                                 String modelVoiture,
                                                 Integer placesDispo,
                                                 Double budget,
                                                 Pageable pageable,long festivaId){
            Page<Covoiturage> covoiturages = covoiturageComponent.getCovoituragesCriteria( nomCommune,
                    modelVoiture,
                    placesDispo,
                    budget,
                    pageable, festivaId);
            List<Covoiturage> covoiturageList = covoiturages.getContent();
            List<CovoiturageDTO> covoiturageDTOS = new ArrayList<>();
            for(Covoiturage covoiturage:covoiturageList){
                CovoiturageDTO covoiturageDTO = covoiturageMapper.entityToDTO(covoiturage);
                covoiturageDTOS.add(covoiturageDTO);
            }
            return covoiturageDTOS;
    }


}
