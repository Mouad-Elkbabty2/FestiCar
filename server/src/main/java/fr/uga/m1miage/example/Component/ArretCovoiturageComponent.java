package fr.uga.m1miage.example.Component;

import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.repository.ArretCovoitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArretCovoiturageComponent {
    private final ArretCovoitRepository arretCovoitRepository;

    public String getHoraireByCovoitIdAndLieuCovoit(Long id, String idLieu) throws EntityNotFound{
        return  arretCovoitRepository.getHoraireByCovoitIdAndLieuCovoit(id,idLieu);
    }
}


