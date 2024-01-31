package fr.uga.m1miage.example.service;


import fr.uga.m1miage.example.Component.UtilisateurComponent;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.UtilisateurMapper;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import fr.uga.m1miage.example.request.CreateUtilisateurRequest;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UtilisateurService {
    private final UtilisateurComponent utilisateurComponent ;
    private final UtilisateurMapper utilisateurMapper ;
    private final UtilisateurRepository utilisateurRepository ;


    @SneakyThrows
    @Transactional
    public UtilisateurDTO getUtilisateurById(final long id)  {
        try{
            Utilisateur utilisateur = utilisateurComponent.getUtilisateur(id);
            UtilisateurDTO utilisateurDTO = utilisateurMapper.entityToDTO(utilisateur) ;
            return utilisateurDTO;
        }catch(EntityNotFound e){
            throw new EntityNotFound("Impossible de charger l'entité utilisateur");
        }
    }
    @SneakyThrows
    @Transactional
    public UtilisateurDTO createUtilisateur(final CreateUtilisateurRequest request)  {
        Utilisateur newUtilisateur = utilisateurMapper.dtoToEntityCreation(request);
            return utilisateurComponent.createUtilisateur(newUtilisateur);

    }
    @SneakyThrows
    @Transactional
    public void deleteUtilisateur(final long id)  {
        try {
            utilisateurComponent.deleteUtilitsateur(id);
        } catch (EntityNotFound ex) {
            throw new EntityNotFound("Impossible de supprimer l'entité.");
        }
    }

    @SneakyThrows
    @Transactional
    public UtilisateurDTO getUtilisateurByEmail(String email){
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurByEmail(email);
        if(utilisateur == null){
            throw new EntityNotFound("Utilisateur not found ");
        }
        return utilisateurMapper.entityToDTO(utilisateur);
}




}
