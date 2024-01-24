package fr.uga.m1miage.example.endpoint;


import fr.uga.m1miage.example.error.EntityNotFound;
import fr.uga.m1miage.example.request.CreateUtilisateurRequest;
import fr.uga.m1miage.example.response.UtilisateurDTO;
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

@Tag(name = "Utilisateur tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/utilisateur/" , produces = "application/json")
public interface UtilisateurEndPoint {

    @GetMapping("{id}")
    @Operation(summary = "Get a Utilisateur by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Utilisateur",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UtilisateurDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Utilisateur not found",
                    content = @Content) })

    UtilisateurDTO getUtilisateurById(@PathVariable("id") Long id) ;


    @PostMapping
    @Operation(description = "Création d'une entité UtilisateurDTO")
    @ApiResponse(responseCode = "201", description = "L'entité Utilitsateur a bien été créée.")

    @ResponseStatus(HttpStatus.CREATED)
    UtilisateurDTO createUtilisateur(@Valid @RequestBody CreateUtilisateurRequest createUtilisateurRequest) throws  EntityNotFound ;

    @DeleteMapping("{id}")
    @Operation(description = "Suppression d'un utilisateur en bd")
    @ApiResponse(responseCode = "201", description = "L'entité Utilitsateur a bien été supprimé.")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = EntityNotFound.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    void deleteUtilitsater(@PathVariable long id) ;
}
