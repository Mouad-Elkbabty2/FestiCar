package fr.uga.m1miage.example.component;


import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.models.Domaine;
import fr.uga.m1miage.example.repository.DomaineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class DomaineComponent {

    private final DomaineRepository domaineRepository;
    public List<Domaine> getDomaines() throws EntityNotFound {
        List<Domaine> domaineList = domaineRepository.getAllDomaines();
        if(domaineList.isEmpty()){
            throw new EntityNotFound("Domaines n'exisite pas");
        }
        return domaineList;
    }
}
