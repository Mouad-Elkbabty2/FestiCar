package fr.uga.m1miage.example.endpoint;


import fr.uga.m1miage.example.error.EntityNotFound;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Panier tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/panier/" , produces = "application/json")
public interface PanierEndPoint {

    @DeleteMapping("{id}")
    @Operation(description = "Suppression d'un panier en bd")
    @ApiResponse(responseCode = "201", description = "L'entité Panier a bien été supprimé.")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = EntityNotFound.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    void deletePanier(@PathVariable long id) ;
    @PostMapping("{utilisateurId}")
    @Operation(description = "Création d'une entité PanierDTO ")
    @ApiResponse(responseCode = "201", description = "L'entité Panier a bien été créée.")

    @ResponseStatus(HttpStatus.CREATED)
    PanierDTO createPanier(@PathVariable final long utilisateurId,@Valid @RequestBody CreatePanierRequest createPanierRequest) throws  EntityNotFound ;


    @GetMapping("{id}")
    @Operation(summary = "Get a Panier by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Panier",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PanierDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Panier not found",
                    content = @Content) })

    PanierDTO getPanierById(@PathVariable("id") Long id) ;

    @GetMapping
    @Operation(summary = "Get a Panier by its utilisateurId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Panier",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PanierDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Panier not found",
                    content = @Content) })
    List<PanierDTO> getPanierByUtilisateur(long utilisateurId);
    @CrossOrigin
    @PatchMapping("/user")
    @Operation(summary = "affect panier to utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Panier patched",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PanierDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Panier not found",
                    content = @Content) })
    @ResponseStatus(HttpStatus.OK)
    void setPanierUser(long panierId , long userId);
}
