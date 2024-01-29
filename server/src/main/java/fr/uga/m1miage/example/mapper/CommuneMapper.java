package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Commune;
import fr.uga.m1miage.example.response.CommuneDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommuneMapper {

    CommuneDTO entityToDTO(Commune commune);

}
