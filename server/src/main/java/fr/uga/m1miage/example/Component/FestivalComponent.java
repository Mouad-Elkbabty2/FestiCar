package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.mapper.FestivalMapper;
import fr.uga.m1miage.example.repository.FestivalRepository;
import fr.uga.m1miage.example.response.FestivalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FestivalComponent {

    private final FestivalRepository festivalRepository ;
    private final FestivalMapper festivalMapper ;

    public List<FestivalDTO> getFestivals()  {

        return null;
    }
}
