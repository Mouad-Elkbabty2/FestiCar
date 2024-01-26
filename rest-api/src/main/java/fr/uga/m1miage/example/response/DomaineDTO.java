package fr.uga.m1miage.example.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class DomaineDTO {
    private String nomDomaine;

    private List<SousDomaineDTO> sousDomaine;
}
