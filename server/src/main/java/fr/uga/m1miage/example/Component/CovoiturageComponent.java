package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.models.Covoiturage;
import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CovoiturageComponent {

    private final CovoiturageRepository covoiturageRepository;
    private final FestivalRepository festivalRepository;

    public List<String> getModeleVoiture(){
        List<String> modeles = covoiturageRepository.getModeleVoiture();
        return  modeles;
    }

    public Page<Covoiturage> getCovoiturageByFestivalId(Long id ,Pageable pageable) throws EntityNotFound{
        Festival fes = festivalRepository.getFestivalByIdFestival(id);
        Page<Covoiturage> covoits = covoiturageRepository.getCovoiturageByFestival(fes ,pageable);
        if (covoits == null) {
            throw new EntityNotFound("aucun covoit n'existe pour ce festival");
        }

        return  covoits;
    }
}
