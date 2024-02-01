package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.ArretCovoiturageComponent;
import fr.uga.m1miage.example.response.HoraireDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class ArretCovoiturageServiceTest {

    @InjectMocks
    private ArretCovoiturageService arretCovoiturageService;

    @Mock
    private ArretCovoiturageComponent arretCovoiturageComponent;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testGetHoraireByCovoitIdAndLieuCovoit() {
        Long covoitId = 1L;
        String lieuCovoitId = "A";
        HoraireDTO expectedHoraire = new HoraireDTO();

        when(arretCovoiturageComponent.getHoraireByCovoitIdAndLieuCovoit(covoitId, lieuCovoitId)).thenReturn(expectedHoraire.getHoraire());

        HoraireDTO actualHoraireDTO = arretCovoiturageService.getHoraireByCovoitIdAndLieuCovoit(covoitId, lieuCovoitId);

        assertEquals(new HoraireDTO(expectedHoraire.getHoraire()), actualHoraireDTO);

        verify(arretCovoiturageComponent, times(1)).getHoraireByCovoitIdAndLieuCovoit(covoitId, lieuCovoitId);
    }

}
