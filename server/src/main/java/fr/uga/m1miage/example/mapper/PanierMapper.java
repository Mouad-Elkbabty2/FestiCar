package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring",uses = {UtilisateurMapper.class})
public interface PanierMapper {
    List<PanierDTO> entityToDTOList(List<Panier> panier);

    PanierDTO entityToDTO(Panier panier);
    Panier dtoToEntity(PanierDTO panierDTO);
    Panier dtoToEntityCreation(CreatePanierRequest createPanierRequest);


}