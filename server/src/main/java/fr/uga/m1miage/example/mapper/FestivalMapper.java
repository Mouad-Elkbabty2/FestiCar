package fr.uga.m1miage.example.mapper;
import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.response.FestivalDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {UtilisateurMapper.class})
public interface FestivalMapper {
    FestivalDTO entityToDTO(Festival festival);


}