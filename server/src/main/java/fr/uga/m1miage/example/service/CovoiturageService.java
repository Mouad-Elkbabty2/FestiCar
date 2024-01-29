package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.Component.CovoiturageComponent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CovoiturageService {
    public final CovoiturageComponent covoiturageComponent;

    @SneakyThrows
    @Transactional
    public List<String> getModeleVoiture(){
        List<String> modeles = covoiturageComponent.getModeleVoiture();
        return  modeles;
    }

}
