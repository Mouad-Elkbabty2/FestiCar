package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.Exception.EntityAlreadyExists;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.PanierMapper;
import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.repository.PanierRepository;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import fr.uga.m1miage.example.response.PanierDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PanierComponent {

    private final PanierRepository panierRepository;
    private final PanierMapper panierMapper ;
    private final UtilisateurRepository utilisateurRepository ;
    public void deletePanier(final long id)  throws EntityNotFound {
        Panier panier = panierRepository.findPanierByIdPanier(id);
        if(panier == null){
            throw new EntityNotFound("Panier existe déjà en BD.");
        }
        panierRepository.deleteById(id);
    }

    public PanierDTO createPanier(final long id , final Panier panier) throws EntityAlreadyExists {
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurById(id);
        if(utilisateur == null){
            throw new EntityAlreadyExists("Utilisateur avec cette id  n'existe pas en BD.");
        }
        panier.setUtilisateur(utilisateur);
        utilisateur.getPanier().add(panier);
        panierRepository.save(panier);
        return panierMapper.entityToDTO(panier);
    }

    public Panier getPanier(final Long panierId) throws EntityNotFound {
        Panier panier = panierRepository.findPanierByIdPanier(panierId);
        if (panier == null) {
            throw new EntityNotFound("Panier n'existe pas dans la bdd");
        }
        return panier;
    }
}
