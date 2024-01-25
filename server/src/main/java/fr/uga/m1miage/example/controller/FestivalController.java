package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.FestivalEndPoint;
import fr.uga.m1miage.example.response.FestivalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class FestivalController implements FestivalEndPoint {
    @Override
    public List<FestivalDTO> getAllFestivals() {
        return null;
    }
}
