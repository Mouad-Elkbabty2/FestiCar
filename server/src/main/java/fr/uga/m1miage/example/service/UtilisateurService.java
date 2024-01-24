package fr.uga.m1miage.example.service;


import fr.uga.m1miage.example.Component.UtilisateurComponent;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.UtilisateurMapper;
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
}
