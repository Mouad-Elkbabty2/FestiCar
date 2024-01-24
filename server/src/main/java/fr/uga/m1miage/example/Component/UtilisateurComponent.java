package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.UtilisateurMapper;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UtilisateurComponent {
    private final UtilisateurRepository utilisateurRepository;


    public Utilisateur getUtilisateur(final Long utilisateurId) throws EntityNotFound {
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurById(utilisateurId);
        if (utilisateur == null) {
            throw new EntityNotFound("Utilisateur n'existe pas dans la bdd");
        }
        return utilisateur;
    }

}