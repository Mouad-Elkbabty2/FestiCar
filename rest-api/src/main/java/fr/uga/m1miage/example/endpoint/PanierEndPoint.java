package fr.uga.m1miage.example.endpoint;


import fr.uga.m1miage.example.error.EntityNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

}
