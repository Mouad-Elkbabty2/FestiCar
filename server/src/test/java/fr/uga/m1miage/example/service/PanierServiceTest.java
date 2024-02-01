package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.PanierComponent;
import fr.uga.m1miage.example.mapper.PanierMapper;
import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.repository.PanierRepository;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class PanierServiceTest {

    @InjectMocks
    private PanierService panierService;

    @Mock
    private PanierComponent panierComponent;

    @Mock
    private PanierMapper panierMapper;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Mock
    private PanierRepository panierRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @SneakyThrows
     void testCreatePanier() {
        CreatePanierRequest createPanierRequest = new CreatePanierRequest();
        Panier newPanier = new Panier();
        PanierDTO expectedPanierDTO = new PanierDTO();

        when(panierMapper.dtoToEntityCreation(createPanierRequest)).thenReturn(newPanier);
        when(panierComponent.createPanier(1L, newPanier)).thenReturn(expectedPanierDTO);

        PanierDTO actualPanierDTO = panierService.createPanier(1L, createPanierRequest);

        assertEquals(expectedPanierDTO, actualPanierDTO);
    }

    @Test
    @SneakyThrows
     void testDeletePanier() {
        doNothing().when(panierComponent).deletePanier(1L);

        panierService.deletePanier(1L);

        verify(panierComponent).deletePanier(1L);
    }

    @Test
    @SneakyThrows
     void testGetPanier() {
        Panier panier = new Panier();
        PanierDTO expectedPanierDTO = new PanierDTO();

        when(panierComponent.getPanier(1L)).thenReturn(panier);
        when(panierMapper.entityToDTO(panier)).thenReturn(expectedPanierDTO);

        PanierDTO actualPanierDTO = panierService.getPanier(1L);

        assertEquals(expectedPanierDTO, actualPanierDTO);
    }

    @Test
     void testGetPanierByUtilisateurId() {
        Panier panier1 = new Panier();
        Panier panier2 = new Panier();
        List<Panier> panierList = Arrays.asList(panier1, panier2);
        List<PanierDTO> expectedPanierDTOList = Arrays.asList(new PanierDTO(), new PanierDTO());

        when(utilisateurRepository.getPanierByUtilisateurId(1L)).thenReturn(panierList);
        when(panierMapper.entityToDTOList(panierList)).thenReturn(expectedPanierDTOList);

        List<PanierDTO> actualPanierDTOList = panierService.getPanierByUtilisateurId(1L);

        assertEquals(expectedPanierDTOList, actualPanierDTOList);
    }

    @Test
     void testSetPanierUser() {
        Panier panier = new Panier();
        when(panierRepository.findPanierByIdPanier(1L)).thenReturn(panier);
        when(utilisateurRepository.getUtilisateurById(2L)).thenReturn(new Utilisateur());

        panierService.setPanierUser(1L, 2L);

        verify(panierRepository).save(panier);
    }
}

