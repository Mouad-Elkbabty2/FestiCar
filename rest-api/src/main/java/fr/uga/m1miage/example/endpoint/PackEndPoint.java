package fr.uga.m1miage.example.endpoint;


import fr.uga.m1miage.example.error.EntityNotFound;
import fr.uga.m1miage.example.request.CreatePackRequest;
import fr.uga.m1miage.example.response.PackDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Pack tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/pack/" , produces = "application/json")
public interface PackEndPoint {
    @PostMapping
    @Operation(description = "Création d'une entité PackDTO")
    @ApiResponse(responseCode = "201", description = "L'entité Pack a bien été créée.")

    @ResponseStatus(HttpStatus.CREATED)
    PackDTO createPack(@Valid @RequestBody CreatePackRequest createPackRequest) throws EntityNotFound;


}
