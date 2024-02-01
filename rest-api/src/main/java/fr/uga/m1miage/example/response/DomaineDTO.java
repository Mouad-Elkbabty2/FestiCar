package fr.uga.m1miage.example.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DomaineDTO {
    private String nomDomaine;

    private List<SousDomaineDTO> sousDomaine;
}
