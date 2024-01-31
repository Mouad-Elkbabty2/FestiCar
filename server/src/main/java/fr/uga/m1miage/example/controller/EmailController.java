package fr.uga.m1miage.example.controller;

import fr.uga.m1miage.example.endpoint.EmailEndPoint;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import fr.uga.m1miage.example.service.EmailService;
import fr.uga.m1miage.example.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController implements EmailEndPoint {

    private final EmailService emailService ;
    private final UtilisateurService utilisateurService ;
    @Override
    public String confirmPayment(long utilisateurId) {
        UtilisateurDTO utilisateur = utilisateurService.getUtilisateurById(utilisateurId);
            String userEmail = utilisateur.getEmail();
            emailService.sendPaymentConfirmation(userEmail, "Confirmation de paiement", "Votre paiement a été confirmé avec succès.");
            return "Paiement confirmé et e-mail envoyé.";
        }
}
