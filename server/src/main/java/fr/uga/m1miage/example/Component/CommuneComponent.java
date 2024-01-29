package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.models.Commune;
import fr.uga.m1miage.example.repository.CommuneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommuneComponent {

private final CommuneRepository communeRepository;

    public List<Commune> getCommunes() throws EntityNotFound {
        List<Commune> communeList = communeRepository.getAllCommunes();
        if(communeList.size() == 0){
            throw new EntityNotFound("Communes n'exisite pas");
        }
        return communeList;
    }
}
