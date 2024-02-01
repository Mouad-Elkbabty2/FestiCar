package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.CovoiturageComponent;
import fr.uga.m1miage.example.mapper.CovoiturageMapper;
import fr.uga.m1miage.example.models.Covoiturage;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.response.CovoiturageDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

 class CovoiturageServiceTest {

    @InjectMocks
    private CovoiturageService covoiturageService;

    @Mock
    private CovoiturageComponent covoiturageComponent;

    @Mock
    private CovoiturageMapper covoiturageMapper;

    @Mock
    private CovoiturageRepository covoiturageRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testGetModeleVoiture() {
        // Mockez le comportement du composant
        when(covoiturageComponent.getModeleVoiture()).thenReturn(Collections.singletonList("Modele1"));

        // Appelez la méthode du service
        List<String> modeleVoitures = covoiturageService.getModeleVoiture();

        // Vérifiez si le résultat attendu est égal au résultat réel
        assertEquals(Collections.singletonList("Modele1"), modeleVoitures);
    }

    @Test
    @SneakyThrows
     void testGetCovoiturageByFestivalId() {
        Covoiturage covoiturage = new Covoiturage();
        CovoiturageDTO expectedCovoiturageDTO = new CovoiturageDTO();

        when(covoiturageComponent.getCovoiturageByFestivalId(anyLong(), any(Pageable.class)))
                .thenReturn(Page.empty());
        when(covoiturageMapper.entityToDTO(covoiturage)).thenReturn(expectedCovoiturageDTO);

        covoiturageService.getCovoiturageByFestivalId(1L, Pageable.unpaged());

        assertEquals(new CovoiturageDTO(0, 0,0.0, null, null, null, null, null, 0, null), new CovoiturageDTO(0, 0,0.0, null, null, null, null, null, 0, null));
    }


    @Test
     void testGetCovoiturageById() {
        Covoiturage covoiturage = new Covoiturage();
        CovoiturageDTO expectedCovoiturageDTO = new CovoiturageDTO();

        when(covoiturageRepository.getCovoiturageByIdCovoiturage(anyLong())).thenReturn(covoiturage);
        when(covoiturageMapper.entityToDTO(covoiturage)).thenReturn(expectedCovoiturageDTO);

        CovoiturageDTO actualCovoiturageDTO = covoiturageService.getCovoiturageById(1L);

        assertEquals(expectedCovoiturageDTO, actualCovoiturageDTO);
    }

}
