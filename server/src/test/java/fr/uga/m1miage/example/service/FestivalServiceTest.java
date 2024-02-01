package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.FestivalComponent;
import fr.uga.m1miage.example.mapper.FestivalMapper;
import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.response.FestivalDTO;
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
import static org.mockito.Mockito.*;

 class FestivalServiceTest {

    @InjectMocks
    private FestivalService festivalService;

    @Mock
    private FestivalComponent festivalComponent;

    @Mock
    private FestivalMapper festivalMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @SneakyThrows
     void testGetAllFestivals() {
        // Créez des objets factices pour les besoins du test
        Festival festival = new Festival();
        FestivalDTO expectedFestivalDTO = new FestivalDTO();

        // Mockez le comportement du composant
        when(festivalComponent.getFestivals()).thenReturn(Collections.singletonList(festival));
        when(festivalMapper.entityToDTO(festival)).thenReturn(expectedFestivalDTO);

        // Appelez la méthode du service
        List<FestivalDTO> actualFestivalDTOList = festivalService.getAllFestivals();

        // Vérifiez si le résultat attendu est égal au résultat réel
        assertEquals(Collections.singletonList(expectedFestivalDTO), actualFestivalDTOList);
    }

    @Test
     void testGetAllFestivalsByCriteria() {
        // Créez des objets factices pour les besoins du test
        Festival festival = new Festival();
        FestivalDTO expectedFestivalDTO = new FestivalDTO();
        Page<Festival> festivalsPage = mock(Page.class);

        // Mockez le comportement du composant
        when(festivalComponent.getFestivalsByCriteria(any(), any(), any(), any(), any(), any())).thenReturn(festivalsPage);
        when(festivalsPage.getContent()).thenReturn(Collections.singletonList(festival));
        when(festivalMapper.entityToDTO(festival)).thenReturn(expectedFestivalDTO);

        // Appelez la méthode du service
        List<FestivalDTO> actualFestivalDTOList = festivalService.getAllFestivalsByCriteria("nom", "dateDebut", "dateFin", 10.0, "sousDomaine", mock(Pageable.class));

        // Vérifiez si le résultat attendu est égal au résultat réel
        assertEquals(Collections.singletonList(expectedFestivalDTO), actualFestivalDTOList);
    }

    @Test
    @SneakyThrows
     void testGetFestivalById() {
        // Créez des objets factices pour les besoins du test
        Festival festival = new Festival();
        FestivalDTO expectedFestivalDTO = new FestivalDTO();

        // Mockez le comportement du composant
        when(festivalComponent.getFestivalById(1L)).thenReturn(festival);
        when(festivalMapper.entityToDTO(festival)).thenReturn(expectedFestivalDTO);

        // Appelez la méthode du service
        FestivalDTO actualFestivalDTO = festivalService.getFestivalById(1L);

        // Vérifiez si le résultat attendu est égal au résultat réel
        assertEquals(expectedFestivalDTO, actualFestivalDTO);
    }
}
