package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PanierMapper {
    PanierDTO entityToDTO(Panier panier);
    Panier DtoToEntity(PanierDTO panierDTO);
    Panier DtoToEntityCreation(CreatePanierRequest createPanierRequest);
}
