package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.FestivalMapper;
import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FestivalComponent {

    private final FestivalRepository festivalRepository ;
    private final FestivalMapper festivalMapper ;

    public List<Festival> getFestivals() throws EntityNotFound {
        List<Festival> festivals = festivalRepository.getAllFestivals();
        if(festivals.size() == 0){
            throw new EntityNotFound("Festivals n'exisite pas");
        }
        return festivals;
    }


}
