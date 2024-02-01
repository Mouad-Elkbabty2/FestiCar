package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.UtilisateurComponent;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.UtilisateurMapper;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import fr.uga.m1miage.example.request.CreateUtilisateurRequest;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UtilisateurServiceTest {

    @Mock
    private UtilisateurComponent utilisateurComponent;

    @Mock
    private UtilisateurMapper utilisateurMapper;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUtilisateurById() throws EntityNotFound {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setEmail("test@example.com");

        when(utilisateurComponent.getUtilisateur(1L)).thenReturn(utilisateur);
        when(utilisateurMapper.entityToDTO(utilisateur)).thenReturn(new UtilisateurDTO());

        UtilisateurDTO result = utilisateurService.getUtilisateurById(1L);

        assertNotNull(result);
        verify(utilisateurComponent, times(1)).getUtilisateur(1L);
        verify(utilisateurMapper, times(1)).entityToDTO(utilisateur);
    }

    @Test
    @SneakyThrows
    void testCreateUtilisateur()  {
        CreateUtilisateurRequest request = new CreateUtilisateurRequest();
        request.setEmail("test@example.com");

        Utilisateur newUtilisateur = new Utilisateur();
        newUtilisateur.setId(1L);
        newUtilisateur.setEmail("test@example.com");

        when(utilisateurMapper.dtoToEntityCreation(request)).thenReturn(newUtilisateur);
        when(utilisateurComponent.createUtilisateur(newUtilisateur)).thenReturn(new UtilisateurDTO());

        UtilisateurDTO result = utilisateurService.createUtilisateur(request);

        assertNotNull(result);
        verify(utilisateurMapper, times(1)).dtoToEntityCreation(request);
        verify(utilisateurComponent, times(1)).createUtilisateur(newUtilisateur);
    }

    @Test
    void testDeleteUtilisateur() throws EntityNotFound {
        doNothing().when(utilisateurComponent).deleteUtilitsateur(1L);

        assertDoesNotThrow(() -> utilisateurService.deleteUtilisateur(1L));

        verify(utilisateurComponent, times(1)).deleteUtilitsateur(1L);
    }

    @Test
    @SneakyThrows
    void testGetUtilisateurByEmail()  {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setEmail("test@example.com");

        when(utilisateurRepository.getUtilisateurByEmail("test@example.com")).thenReturn(utilisateur);
        when(utilisateurMapper.entityToDTO(utilisateur)).thenReturn(new UtilisateurDTO());

        UtilisateurDTO result = utilisateurService.getUtilisateurByEmail("test@example.com");

        assertNotNull(result);
        verify(utilisateurRepository, times(1)).getUtilisateurByEmail("test@example.com");
        verify(utilisateurMapper, times(1)).entityToDTO(utilisateur);
    }

    @Test
    void testGetUtilisateurByEmailNotFound() {
        when(utilisateurRepository.getUtilisateurByEmail("nonexistent@example.com")).thenReturn(null);

        assertThrows(EntityNotFound.class, () -> utilisateurService.getUtilisateurByEmail("nonexistent@example.com"));
    }
}
