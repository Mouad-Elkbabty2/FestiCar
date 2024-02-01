package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.DomaineComponent;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.DomaineMapper;
import fr.uga.m1miage.example.models.Domaine;
import fr.uga.m1miage.example.response.DomaineDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class DomaineServiceTest {

    @InjectMocks
    private DomaineService domaineService;

    @Mock
    private DomaineComponent domaineComponent;

    @Mock
    private DomaineMapper domaineMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @SneakyThrows
     void testGetAllDomaines() {
        Domaine domaine = new Domaine();
        DomaineDTO expectedDomaineDTO = new DomaineDTO();

        when(domaineComponent.getDomaines()).thenReturn(Collections.singletonList(domaine));
        when(domaineMapper.entityToDTO(domaine)).thenReturn(expectedDomaineDTO);

        List<DomaineDTO> actualDomaineDTOList = domaineService.getAllDomaines();

        assertEquals(Collections.singletonList(expectedDomaineDTO), actualDomaineDTOList);
    }



}
