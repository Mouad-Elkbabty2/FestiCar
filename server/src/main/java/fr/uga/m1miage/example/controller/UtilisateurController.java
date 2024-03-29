package fr.uga.m1miage.example.controller;


import fr.uga.m1miage.example.endpoint.UtilisateurEndPoint;
import fr.uga.m1miage.example.request.CreateUtilisateurRequest;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import fr.uga.m1miage.example.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UtilisateurController implements UtilisateurEndPoint {

    private final UtilisateurService utilisateurService;

    @Override
    public UtilisateurDTO getUtilisateurById(Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @Override
    public UtilisateurDTO getUtilisateurByEmail(String email) {
        return utilisateurService.getUtilisateurByEmail(email);
    }

    @Override
    public UtilisateurDTO getUtilisateurByEmailAndMdp(String email,String mdp) {
        return utilisateurService.getUtilisateurByEmailAndMDP(email,mdp);
    }

    @Override
    public UtilisateurDTO createUtilisateur(final CreateUtilisateurRequest request)  {
            return  utilisateurService.createUtilisateur(request);
        }

    @Override
    public void deleteUtilisateur(long id) {
          utilisateurService.deleteUtilisateur(id);
    }
}