package fr.uga.m1miage.example.component;


import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FestivalComponent {

    private final FestivalRepository festivalRepository ;

    public List<Festival> getFestivals() throws EntityNotFound {
        List<Festival> festivals = festivalRepository.getAllFestivals();
        if(festivals.isEmpty()){
            throw new EntityNotFound("Festivals n'exisite pas");
        }
        return festivals;
    }

    public Page<Festival> getFestivalsByCriteria( String nomFestival,
                                                  String dateDebut,
                                                  String dateFin,
                                                   Double tarif,
                                                   String sousDomaine, Pageable pageable)  {

        return festivalRepository.findFestivalsByCriteria(nomFestival,dateDebut,dateFin,tarif,sousDomaine, pageable);
    }

    public Festival getFestivalById(final Long id) throws EntityNotFound{
        Festival festival = festivalRepository.getFestivalByIdFestival(id);
        if (festival == null){
            throw new EntityNotFound("Panier n'existe pas dans la bdd");
        }
        return festival;
    }

}
