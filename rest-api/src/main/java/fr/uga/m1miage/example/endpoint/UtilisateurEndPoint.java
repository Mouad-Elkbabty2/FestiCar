package fr.uga.m1miage.example.endpoint;


import fr.uga.m1miage.example.request.CreateUtilisateurRequest;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
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


    @PostMapping()
    @Operation(summary = "Create Utilisateur ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UtilisateurDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied",
                    content = @Content) })
    @ResponseStatus(HttpStatus.CREATED)
    UtilisateurDTO createUtilisateur(@Valid @RequestBody CreateUtilisateurRequest createUtilisateurRequest) ;
}
