package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.Component.PanierComponent;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.PanierMapper;
import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PanierService {

    private final PanierComponent panierComponent ;
    private final PanierMapper panierMapper;

    @SneakyThrows
    @Transactional
    public void deletePanier(final long id)  {
        try {
            panierComponent.deletePanier(id);
        } catch (EntityNotFound ex) {
            throw new EntityNotFound("Impossible de supprimer l'entité.");
        }
    }
    @SneakyThrows
    @Transactional
    public PanierDTO createPanier(final long utilitsateurId , final CreatePanierRequest request)  {
        Panier newPanier = panierMapper.DtoToEntityCreation(request);
        return panierMapper.entityToDTO(newPanier);
    }

    @SneakyThrows
    @Transactional
    public PanierDTO getPanier(final long id)  {
        try{
            return panierMapper.entityToDTO(panierComponent.getPanier(id));
        }catch(EntityNotFound e){
            throw new EntityNotFound("Impossible de charger l'entité panier");
        }
    }
}
