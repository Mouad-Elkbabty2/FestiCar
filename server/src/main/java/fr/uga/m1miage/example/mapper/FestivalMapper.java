package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Commune;
import fr.uga.m1miage.example.models.Covoiturage;
import fr.uga.m1miage.example.models.Festival;
import fr.uga.m1miage.example.models.SousDomaine;
import fr.uga.m1miage.example.response.CommuneDTO;
import fr.uga.m1miage.example.response.CovoiturageDTO;
import fr.uga.m1miage.example.response.FestivalDTO;
import fr.uga.m1miage.example.response.SousDomaineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FestivalMapper {

    FestivalDTO entityToDTO(Festival festival);
    Festival dtoToEntity(FestivalDTO festivalDTO);

    CovoiturageDTO map(Covoiturage covoiturage);

    SousDomaineDTO map(SousDomaine sousDomaine);
    CommuneDTO map(Commune commune);


}
