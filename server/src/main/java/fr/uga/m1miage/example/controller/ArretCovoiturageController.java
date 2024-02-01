package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.ArretCovoiturageEndPoint;
import fr.uga.m1miage.example.response.HoraireDTO;
import fr.uga.m1miage.example.service.ArretCovoiturageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ArretCovoiturageController implements ArretCovoiturageEndPoint {
    private final ArretCovoiturageService arretCovoiturageService;

    @Override
    public HoraireDTO getHoraireByCovoitIdAndLieuId(Long id, String idLieu) {
        return arretCovoiturageService.getHoraireByCovoitIdAndLieuCovoit(id,idLieu);
    }
}
