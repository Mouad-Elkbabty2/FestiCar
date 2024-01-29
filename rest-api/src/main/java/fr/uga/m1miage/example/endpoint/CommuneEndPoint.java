package fr.uga.m1miage.example.endpoint;


import fr.uga.m1miage.example.response.CommuneDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Commune tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/" , produces = "application/json")
public interface CommuneEndPoint {

    @GetMapping("allCommune")
    @Operation(summary = "Get all Commune ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Communes",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommuneDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Communes not found",
                    content = @Content) })
    List<CommuneDTO> getAllCommunes() ;
}
