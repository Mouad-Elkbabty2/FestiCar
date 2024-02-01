package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.CommuneComponent;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.CommuneMapper;
import fr.uga.m1miage.example.models.Commune;
import fr.uga.m1miage.example.response.CommuneDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class CommuneServiceTest {

    @InjectMocks
    private CommuneService communeService;

    @Mock
    private CommuneComponent communeComponent;

    @Mock
    private CommuneMapper communeMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testGetAllCommunes() throws EntityNotFound {
        Commune commune = new Commune();
        CommuneDTO expectedCommuneDTO = new CommuneDTO();

        when(communeComponent.getCommunes()).thenReturn(Collections.singletonList(commune));
        when(communeMapper.entityToDTO(commune)).thenReturn(expectedCommuneDTO);

        List<CommuneDTO> actualCommuneDTOList = communeService.getAllDomaines();

        assertEquals(Collections.singletonList(expectedCommuneDTO), actualCommuneDTOList);
    }


}

