package fr.uga.m1miage.example.service;


import fr.uga.m1miage.example.component.DomaineComponent;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.DomaineMapper;
import fr.uga.m1miage.example.models.Domaine;
import fr.uga.m1miage.example.response.DomaineDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DomaineService {


private final DomaineComponent domaineComponent;
private final DomaineMapper domaineMapper;

    @SneakyThrows
    @Transactional
    public List<DomaineDTO> getAllDomaines(){
        try{
            List<Domaine> domaineList = domaineComponent.getDomaines();
            List<DomaineDTO> domaineDTOS = new ArrayList<>();
            for(Domaine domaine:domaineList){
                domaineDTOS.add(domaineMapper.entityToDTO(domaine));
            }
            return domaineDTOS;
        }catch(EntityNotFound e){
            throw new EntityNotFound("Impossible de charger les festivals ");
        }
    }
}
