package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.endpoint.ArretCovoiturageEndPoint;
import fr.uga.m1miage.example.models.ArretCovoitId;
import fr.uga.m1miage.example.models.ArretCovoiturage;
import fr.uga.m1miage.example.response.ArretCovoiturageDTO;
import fr.uga.m1miage.example.response.ArretCovoiturageIdDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CovoiturageMapper.class})

public interface ArretCovoiturageMapper {
    fr.uga.m1miage.example.models.ArretCovoiturage dtoToEntity(ArretCovoiturageDTO arretCovoiturageDTO);
    ArretCovoiturageIdDTO dtoToEntityId(ArretCovoitId arretCovoitId);

    List<ArretCovoiturageDTO> entityToDTOList(List<ArretCovoiturage> arretCovoiturageList);
    ArretCovoiturageIdDTO entityIdToDTO(ArretCovoitId arretCovoitId);
    ArretCovoiturageDTO entityToDTO(ArretCovoiturage arretCovoiturage);
}
