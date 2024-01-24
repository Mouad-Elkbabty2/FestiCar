package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurDTO entityToDTO(Utilisateur utilisateur);
    Utilisateur DtoToEntity(UtilisateurDTO utilisateurDTO);
}
