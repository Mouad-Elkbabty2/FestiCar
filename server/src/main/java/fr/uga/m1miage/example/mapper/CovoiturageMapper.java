package fr.uga.m1miage.example.mapper;

import fr.uga.m1miage.example.models.Covoiturage;
import fr.uga.m1miage.example.response.CovoiturageDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UtilisateurMapper.class})
public interface CovoiturageMapper {
    CovoiturageDTO entityToDTO(Covoiturage covoiturage);

    List<CovoiturageDTO> entityToDTOList(List<Covoiturage> covoiturage);


}
