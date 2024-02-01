package fr.uga.m1miage.example.endpoint;


import fr.uga.m1miage.example.error.EntityNotFound;
import fr.uga.m1miage.example.request.CreatePackRequest;
import fr.uga.m1miage.example.response.PackDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Pack tag")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value="api/pack/" , produces = "application/json")
public interface PackEndPoint {
    @PostMapping
    @Operation(description = "Création d'une entité PackDTO")
    @ApiResponse(responseCode = "201", description = "L'entité Pack a bien été créée.")

    @ResponseStatus(HttpStatus.CREATED)
    PackDTO createPack(@Valid @RequestBody CreatePackRequest createPackRequest) throws EntityNotFound;

    @PutMapping("/updateNbPlaces")
    @Operation(description = "UPDATE d'une entité PackDTO")
    @ApiResponse(responseCode = "200", description = "L'entité Pack a bien été créée.")
    @ResponseStatus(HttpStatus.OK)
    PackDTO updateNbPlaces(@RequestBody CreatePackRequest request);

    @GetMapping("allPack")
    @Operation(summary = "Get all Pack By panier Id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Pack",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Packs not found",
                    content = @Content) })
    List<PackDTO> getAllPackByPanierId(long panierId) ;
    @CrossOrigin("*")
    @PostMapping ("/anas")
    @Operation(summary = "affect panier to utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "L'entité à bien été mis à jour"),
            @ApiResponse(responseCode = "404", description = "Panier not found",
                    content = @Content) })
    @ResponseStatus(HttpStatus.ACCEPTED)
    void setPanierUser(long panierId , long userId);


    @DeleteMapping
    @Operation(summary = "delete pack by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "L'entité à bien été mis à jour"),
            @ApiResponse(responseCode = "404", description = "Panier not found",
                    content = @Content) })
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deletePackById(String horaire, long idCovoiturage,long panierId);
}
