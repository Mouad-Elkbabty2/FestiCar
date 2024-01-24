package fr.uga.m1miage.example.Component;


import fr.uga.m1miage.example.Exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.PanierMapper;
import fr.uga.m1miage.example.mapper.UtilisateurMapper;
import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.Utilisateur;
import fr.uga.m1miage.example.repository.PanierRepository;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PanierComponent {

    private final PanierRepository panierRepository;
    private final PanierMapper panierMapper ;
    public void deletePanier(final long id)  throws EntityNotFound {
        Panier panier = panierRepository.findPanierByIdPanier(id);
        if(panier == null){
            throw new EntityNotFound("Panier existe déjà en BD.");
        }
        panierRepository.deleteById(id);
    }
}
