package fr.uga.m1miage.example.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Arret Covoiturage")
@CrossOrigin
@RestController
@RequestMapping(value="api/" , produces = "application/json")
public interface ArretCovoiturageEndPoint {
    @GetMapping("ArretCovoiturage")
    @Operation(summary = "ModeleVoiture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "horaire found",
                    content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "models not Found",
                    content = @Content) })
    String getHoraireByCovoitIdAndLieuId(@RequestParam Long id , @RequestParam String idLieu);
}
