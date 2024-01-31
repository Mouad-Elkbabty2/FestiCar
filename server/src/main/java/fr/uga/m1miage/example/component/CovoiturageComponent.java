package fr.uga.m1miage.example.component;


import fr.uga.m1miage.example.exception.EntityNotFound;
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
        return  covoiturageRepository.getModeleVoiture();
    }

    public Page<Covoiturage> getCovoiturageByFestivalId(Long id ,Pageable pageable) throws EntityNotFound{
        Festival fes = festivalRepository.getFestivalByIdFestival(id);
        Page<Covoiturage> covoits = covoiturageRepository.getCovoiturageByFestival(fes ,pageable);
        if (covoits == null) {
            throw new EntityNotFound("aucun covoit n'existe pour ce festival");
        }

        return  covoits;
    }

    public Page<Covoiturage> getCovoituragesCriteria( String nomCommune,
                                             String modelVoiture,
                                             Integer placesDispo,
                                             Double budget,
                                             Pageable pageable,long festivalId) {

        return covoiturageRepository.filterCovoiturages(nomCommune,modelVoiture,placesDispo,budget,pageable,festivalId);
    }
}
