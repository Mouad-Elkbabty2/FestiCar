package fr.uga.m1miage.example.service;


import fr.uga.m1miage.example.component.FestivalComponent;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.FestivalMapper;
import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.response.FestivalDTO;
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
public class FestivalService {



    private final FestivalComponent festivalComponent;
    private final FestivalMapper festivalMapper;


    @SneakyThrows
    @Transactional
    public List<FestivalDTO> getAllFestivals(){
        try{
            List<Festival> festivals = festivalComponent.getFestivals();
            List<FestivalDTO> festivalDTOS = new ArrayList<>();
            for(Festival festival:festivals){
                festivalDTOS.add(festivalMapper.entityToDTO(festival));
            }
            return festivalDTOS;
        }catch(EntityNotFound e){
            throw new EntityNotFound("Impossible de charger les festivals ");
        }
    }
    @SneakyThrows
    @Transactional
    public List<FestivalDTO> getAllFestivalsByCriteria(String nomFestival,
                                                       String dateDebut,
                                                       String dateFin,
                                                       Double tarif,
                                                       String sousDomaine, Pageable pageable) {
        Page<Festival> festivalsPage = festivalComponent.getFestivalsByCriteria( nomFestival,
                                                                             dateDebut,
                                                                             dateFin,
                                                                             tarif,
                                                                             sousDomaine,pageable) ;
        List<Festival> festivals = festivalsPage.getContent();
        List<FestivalDTO> festivalDTOS = new ArrayList<>();
        for(Festival festival:festivals){
            festivalDTOS.add(festivalMapper.entityToDTO(festival));
        }
        return festivalDTOS;
    }

    @SneakyThrows
    @Transactional
    public FestivalDTO getFestivalById(final Long id){
        try{
            return festivalMapper.entityToDTO(festivalComponent.getFestivalById(id));
        }catch(EntityNotFound e){
            throw new EntityNotFound("Aucun festival ne possède "+id+" comme id");
        }
    }


}