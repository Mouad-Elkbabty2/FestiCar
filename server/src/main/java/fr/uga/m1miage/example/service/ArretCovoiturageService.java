package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.Component.ArretCovoiturageComponent;
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
    public String getHoraireByCovoitIdAndLieuCovoit(Long id, String idLieu){
        return arretCovoiturageComponent.getHoraireByCovoitIdAndLieuCovoit(id , idLieu);
    }

}
