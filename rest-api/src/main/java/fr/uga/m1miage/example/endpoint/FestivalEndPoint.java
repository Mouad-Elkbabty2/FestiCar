package fr.uga.m1miage.example.endpoint;

import fr.uga.m1miage.example.response.FestivalDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Tag(name = "Festival tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/" , produces = "application/json")
public interface FestivalEndPoint {

    @GetMapping("allFestivals")
    @Operation(summary = "Get all Festivals ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Festivals",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FestivalDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Festivals not found",
                    content = @Content) })
    List<FestivalDTO> getAllFestivals() ;

    @GetMapping("festivals/")
    @Operation(summary = "Search for Festivals based on criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Festivals",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FestivalDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Festivals not found",
                    content = @Content) })
    List<FestivalDTO> getFestivalsByCriteria(
            @RequestParam(name = "nomFestival", required = false) String nomFestival,
            @RequestParam(name = "dateDebut", required = false) String dateDebut,
            @RequestParam(name = "dateFin", required = false) String dateFin,
            @RequestParam(name = "tarif", required = false) Double tarif,
            @RequestParam(name = "sousDomaine", required = false) String sousDomaine, int numPage , int taille

    );


    @GetMapping("Festival/{id}")
    @Operation(summary = "Get festival by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festival fond",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FestivalDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "The given id is invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Panier not found",
                    content = @Content) })
    FestivalDTO getFestivalById(@PathVariable("id") Long id);



}
