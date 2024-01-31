package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.ArretCovoiturageComponent;
import fr.uga.m1miage.example.response.HoraireDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ArretCovoiturageService {
    private final ArretCovoiturageComponent arretCovoiturageComponent;

    @SneakyThrows
    @Transactional
    public HoraireDTO getHoraireByCovoitIdAndLieuCovoit(Long id, String idLieu){
        return new HoraireDTO(arretCovoiturageComponent.getHoraireByCovoitIdAndLieuCovoit(id , idLieu));
    }

}
