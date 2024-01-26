package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Domaine;
import fr.uga.m1miage.example.response.DomaineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface DomaineMapper {

    DomaineDTO entityToDTO(Domaine domaineDTO);
}
