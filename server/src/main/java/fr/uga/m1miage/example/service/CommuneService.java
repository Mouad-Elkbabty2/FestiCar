package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.Component.CommuneComponent;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.CommuneMapper;
import fr.uga.m1miage.example.models.Commune;
import fr.uga.m1miage.example.response.CommuneDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CommuneService {

private final CommuneComponent communeComponent;
private final CommuneMapper communeMapper ;

    @SneakyThrows
    @Transactional
    public List<CommuneDTO> getAllDomaines(){
        try{
            List<Commune> communeList = communeComponent.getCommunes();
            List<CommuneDTO> communeDTOS = new ArrayList<>();
            for(Commune commune:communeList){
                communeDTOS.add(communeMapper.entityToDTO(commune));
            }
            return communeDTOS;
        }catch(EntityNotFound e){
            throw new EntityNotFound("Impossible de charger les communes ");
        }
    }
}
