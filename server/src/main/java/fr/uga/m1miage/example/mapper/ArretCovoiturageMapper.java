package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.ArretCovoitId;
import fr.uga.m1miage.example.response.ArretCovoiturageDTO;
import fr.uga.m1miage.example.response.ArretCovoiturageIdDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {CovoiturageMapper.class})

public interface ArretCovoiturageMapper {
    fr.uga.m1miage.example.models.ArretCovoiturage dtoToEntity(ArretCovoiturageDTO arretCovoiturageDTO);
    ArretCovoiturageIdDTO dtoToEntityId(ArretCovoitId arretCovoitId);
}
