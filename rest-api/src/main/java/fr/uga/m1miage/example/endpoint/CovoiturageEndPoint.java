package fr.uga.m1miage.example.endpoint;

import fr.uga.m1miage.example.response.FestivalDTO;
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

@Tag(name = "Covoiturage")
@CrossOrigin
@RestController
@RequestMapping(value="api/" , produces = "application/json")
public interface CovoiturageEndPoint {
    @GetMapping("Covoiturage/ModeleVoiture")
    @Operation(summary = "ModeleVoiture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "modelesVoitures found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FestivalDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "models not Found",
                    content = @Content) })
    List<String> GetModeleVoiture();
}
