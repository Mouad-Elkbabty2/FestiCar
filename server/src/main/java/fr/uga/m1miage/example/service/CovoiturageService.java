package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.Component.CovoiturageComponent;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.CovoiturageMapper;
import fr.uga.m1miage.example.models.Covoiturage;
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

    @SneakyThrows
    @Transactional
    public List<String> getModeleVoiture(){
        List<String> modeles = covoiturageComponent.getModeleVoiture();
        return  modeles;
    }

    @SneakyThrows
    @Transactional
    public List<CovoiturageDTO> getCovoiturageByFestivalId(Long id, Pageable pageable) {
        try{
            Page<Covoiturage> covoituragesPage = covoiturageComponent.getCovoiturageByFestivalId(id,pageable);
            List<Covoiturage> covoiturages = covoituragesPage.getContent();
            List<CovoiturageDTO> covoitsDTOs = new ArrayList<>();
            for(Covoiturage co:covoiturages){
                covoitsDTOs.add(covoiturageMapper.entityToDTO(co));
            }
            return covoitsDTOs;
        }catch(EntityNotFound e){
            throw new EntityNotFound("Aucun ;covoiturage n'existe pour ce festival");
        }
    }

}
