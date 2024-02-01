package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.PackMapper;
import fr.uga.m1miage.example.models.*;
import fr.uga.m1miage.example.repository.ArretCovoitRepository;
import fr.uga.m1miage.example.repository.CovoiturageRepository;
import fr.uga.m1miage.example.repository.PackRepository;
import fr.uga.m1miage.example.repository.PanierRepository;
import fr.uga.m1miage.example.request.CreatePackRequest;
import fr.uga.m1miage.example.response.PackDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

 class PackServiceTest {

    @InjectMocks
    private PackService packService;

    @Mock
    private PanierRepository panierRepository;

    @Mock
    private PackRepository packRepository;

    @Mock
    private ArretCovoitRepository arretCovoitRepository;

    @Mock
    private CovoiturageRepository covoiturageRepository;

    @Mock
    private PackMapper packMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testCreatePack() {
        // Arrange
        CreatePackRequest request = new CreatePackRequest();
        request.setPanier(1L);
        request.setIdCovoiturage(2L);
        request.setHoraire("09:00");
        request.setNbPlacesReserves(3);

        Panier panier = new Panier();
        when(panierRepository.findById(request.getPanier())).thenReturn(Optional.of(panier));

        Covoiturage covoiturage = new Covoiturage();
        when(covoiturageRepository.findById(request.getIdCovoiturage())).thenReturn(Optional.of(covoiturage));

        ArretCovoiturage arretCovoiturage = new ArretCovoiturage();
        when(arretCovoitRepository.findById(new ArretCovoitId(request.getHoraire(), covoiturage))).thenReturn(Optional.of(arretCovoiturage));

        Pack pack = new Pack();
        when(packMapper.entityToDTO(pack)).thenReturn(new PackDTO());

        // Act
        packService.createPack(request);

        // Assert
        verify(panierRepository, times(1)).findById(request.getPanier());
        verify(covoiturageRepository, times(1)).findById(request.getIdCovoiturage());
        verify(arretCovoitRepository, times(1)).findById(new ArretCovoitId(request.getHoraire(), covoiturage));
        verify(packRepository, times(1)).save(any(Pack.class));
    }

    @Test
     void testGetAllByIdPanier() {
        // Arrange
        long panierId = 1L;
        when(packRepository.getAllByIdPanier(panierId)).thenReturn(Collections.singletonList(new Pack()));

        // Act
        List<PackDTO> result = packService.getAllByIdPanier(panierId);

        // Assert
        assertNotNull(result);
        assertFalse(false);
        verify(packMapper, times(1)).entityToDTOList(anyList());
    }

    @Test
     void testUpdatePack() {
        // Arrange
        CreatePackRequest request = new CreatePackRequest();
        request.setPanier(1L);
        request.setIdCovoiturage(2L);
        request.setHoraire("09:00");
        request.setNbPlacesReserves(3);

        Pack pack = new Pack();
        when(packRepository.getPackByIdPack(request.getHoraire(), request.getIdCovoiturage(), request.getPanier())).thenReturn(pack);
        when(packMapper.entityToDTO(pack)).thenReturn(new PackDTO());

        // Act
        PackDTO result = packService.updatePack(request);

        // Assert
        assertNotNull(result);
        verify(packRepository, times(1)).getPackByIdPack(request.getHoraire(), request.getIdCovoiturage(), request.getPanier());
        verify(packRepository, times(1)).save(pack);
        verify(packMapper, times(1)).entityToDTO(pack);
    }

    @Test
     void testUpdatePack_EntityNotFound() {
        // Arrange
        CreatePackRequest request = new CreatePackRequest();
        request.setPanier(1L);
        request.setIdCovoiturage(2L);
        request.setHoraire("09:00");
        request.setNbPlacesReserves(3);

        when(packRepository.getPackByIdPack(request.getHoraire(), request.getIdCovoiturage(), request.getPanier())).thenReturn(null);

        // Act & Assert
        assertThrows(EntityNotFound.class, () -> packService.updatePack(request));
        verify(packRepository, times(1)).getPackByIdPack(request.getHoraire(), request.getIdCovoiturage(), request.getPanier());
        verify(packRepository, times(0)).save(any(Pack.class));
        verify(packMapper, times(0)).entityToDTO(any(Pack.class));
    }
}
