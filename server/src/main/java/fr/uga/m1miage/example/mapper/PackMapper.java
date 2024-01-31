package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Pack;
import fr.uga.m1miage.example.response.PackDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ArretCovoiturageMapper.class})

public interface PackMapper {
    PackDTO entityToDTO(Pack pack);
}
