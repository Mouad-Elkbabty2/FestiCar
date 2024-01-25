package fr.uga.m1miage.example.endpoint;

import fr.uga.m1miage.example.response.FestivalDTO;
import fr.uga.m1miage.example.response.UtilisateurDTO;
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

    @GetMapping("festivals")
    @Operation(summary = "Get all Festivals ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Festivals",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UtilisateurDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Festivals not found",
                    content = @Content) })
    List<FestivalDTO> getAllFestivals() ;

}
