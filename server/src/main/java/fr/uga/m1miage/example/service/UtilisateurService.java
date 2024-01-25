package fr.uga.m1miage.example.service;


import fr.uga.m1miage.example.Component.UtilisateurComponent;
import fr.uga.m1miage.example.Exception.EntityAlreadyExists;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.UtilisateurMapper;
import fr.uga.m1miage.example.models.Utilisateur;
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


    @SneakyThrows
    @Transactional
    public UtilisateurDTO getUtilisateurById(final long id)  {
        try{
            return utilisateurMapper.entityToDTO(utilisateurComponent.getUtilisateur(id));
        }catch(EntityNotFound e){
            throw new EntityNotFound("Impossible de charger l'entité utilisateur");
        }
    }
    @SneakyThrows
    @Transactional
    public UtilisateurDTO createUtilisateur(final CreateUtilisateurRequest request)  {
        Utilisateur newUtilisateur = utilisateurMapper.DtoToEntity(request);
        try {
            return utilisateurComponent.createUtilisateur(newUtilisateur);
        } catch (EntityAlreadyExists ex) {
            throw new EntityAlreadyExists("Utilisateur dèja existant dans la bdd");
        }
    }}