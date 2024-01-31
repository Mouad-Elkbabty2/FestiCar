package fr.uga.m1miage.example.endpoint;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "mail tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/mail" , produces = "application/json")
public interface EmailEndPoint {

    @PostMapping("/confirm")
    @Operation(summary = "Send mail ")
    @ApiResponse(responseCode = "200", description = "Mail sent.")
    @ResponseStatus(HttpStatus.OK)
     String confirmPayment(long utilisateurId);


}
