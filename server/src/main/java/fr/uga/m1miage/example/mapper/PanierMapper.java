package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PanierMapper {
    PanierDTO entityToDTO(Panier panier);
    Panier DtoToEntity(PanierDTO panierDTO);
    Panier DtoToEntityCreation(CreatePanierRequest createPanierRequest);

    UtilisateurDTO map(Utilisateur utilisateur);
    List<PanierDTO> dtoToEntityList(List<Panier> paniers);

}