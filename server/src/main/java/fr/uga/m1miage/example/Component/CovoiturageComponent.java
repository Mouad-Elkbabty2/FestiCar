package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CovoiturageComponent {

    private final CovoiturageRepository covoiturageRepository;

    public List<String> getModeleVoiture(){
        List<String> modeles = covoiturageRepository.getModeleVoiture();
        return  modeles;
    }
}
