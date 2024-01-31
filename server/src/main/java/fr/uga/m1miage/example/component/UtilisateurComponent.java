package fr.uga.m1miage.example.component;


import fr.uga.m1miage.example.exception.EntityAlreadyExists;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.UtilisateurMapper;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import fr.uga.m1miage.example.response.UtilisateurDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UtilisateurComponent {
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper ;


    public Utilisateur getUtilisateur(final Long utilisateurId) throws EntityNotFound {
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurById(utilisateurId);
        if (utilisateur == null) {
            throw new EntityNotFound("Utilisateur n'existe pas dans la bdd");
        }
        return utilisateur;
    }

    public UtilisateurDTO createUtilisateur(final Utilisateur utilisateur) throws EntityAlreadyExists {
        if(utilisateurRepository.getUtilisateurByEmail(utilisateur.getEmail()) != null){
            throw new EntityAlreadyExists("Utilitsateur avec ce mail existe déjà en BD.");
        }
        else if(utilisateurRepository.getUtilisateurByTelephone(utilisateur.getTelephone()) != null){
            throw new EntityAlreadyExists("Utilitsateur avec ce numero de telepone  existe déjà en BD.");
        }
        else if (utilisateurRepository.getUtilisateurById(utilisateur.getId()) != null) {
            throw new EntityAlreadyExists("Utilitsateur existe déjà en BD.");
        } else {
        utilisateurRepository.save(utilisateur);
        }
        return utilisateurMapper.entityToDTO(utilisateur);
    }

    public void deleteUtilitsateur(final long id)  throws EntityNotFound{
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(id);
        if(utilisateur == null){
            throw new EntityNotFound("Utilitsateur n'existe pas en BD.");
        }

        utilisateurRepository.deleteUtilisateurById(id);
    }
}