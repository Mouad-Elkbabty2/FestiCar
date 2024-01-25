package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.FestivalEndPoint;
import fr.uga.m1miage.example.response.FestivalDTO;
import fr.uga.m1miage.example.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class FestivalController implements FestivalEndPoint {
    private final FestivalService festivalService;
    @Override
    public List<FestivalDTO> getAllFestivals() {
        return festivalService.getAllFestivals();
    }
}
