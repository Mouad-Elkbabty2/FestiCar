package fr.uga.m1miage.example.endpoint;

import fr.uga.m1miage.example.response.CovoiturageDTO;
import fr.uga.m1miage.example.response.FestivalDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Covoiturage tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/" , produces = "application/json")
public interface CovoiturageEndPoint {
    @GetMapping("Covoiturage/ModeleVoiture")
    @Operation(summary = "ModeleVoiture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "modelesVoitures found",
                    content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "models not Found",
                    content = @Content) })
    List<String> getModeleVoiture();

    @GetMapping("Covoiturage")
    @Operation(summary = "Covoiturage by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Covoiturage found",
                    content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "models not Found",
                    content = @Content) })
    CovoiturageDTO getCovoiturageById(long covoiturageId);

    @GetMapping("Covoiturage/{festivalId}")
    @Operation(summary = "Covoiturage by festival id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "covoit not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FestivalDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "models not Found",
                    content = @Content) })
    List<CovoiturageDTO> getCovoiturageByFestivalId(@PathVariable("festivalId") Long id, @RequestParam int numPage , @RequestParam int taillePage);


    @GetMapping("covoituragesCriteria")
    @Operation(summary = "Filter Covoiturages by Criteria ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Covoiturages",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CovoiturageDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid query",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Covoiturages not found",
                    content = @Content)})
    List<CovoiturageDTO> filterCovoiturages(
            @RequestParam(required = false) String nomCommune,
            @RequestParam(required = false) String modelVoiture,
            @RequestParam(required = false) Integer placesDispo,
            @RequestParam(required = false) Double budget,
            int numPage , int taille, long festivalId);
}
