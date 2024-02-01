package fr.uga.m1miage.example.mapper;


import fr.uga.m1miage.example.models.Pack;
import fr.uga.m1miage.example.models.PackId;
import fr.uga.m1miage.example.response.PackDTO;
import fr.uga.m1miage.example.response.PackIdDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ArretCovoiturageMapper.class})

public interface PackMapper {
    PackDTO entityToDTO(Pack pack);

    PackIdDTO entityToDTOId(PackId pack);
    List<PackDTO> entityToDTOList(List<Pack> pack);

}
