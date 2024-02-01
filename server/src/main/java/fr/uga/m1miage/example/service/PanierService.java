package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.component.PanierComponent;
import fr.uga.m1miage.example.exception.EntityNotFound;
import fr.uga.m1miage.example.mapper.PanierMapper;
import fr.uga.m1miage.example.models.EtatPanier;
import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.repository.PanierRepository;
import fr.uga.m1miage.example.repository.UtilisateurRepository;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PanierService {

    private final PanierComponent panierComponent ;
    private final PanierMapper panierMapper;
    private final UtilisateurRepository utilisateurRepository;
    private final PanierRepository panierRepository;


    @SneakyThrows
    @Transactional
    public void deletePanier(final long id)  {
        try {
            panierComponent.deletePanier(id);
        } catch (EntityNotFound ex) {
            throw new EntityNotFound("Impossible de supprimer l'entité.");
        }
    }
    @SneakyThrows
    @Transactional
    public PanierDTO createPanier(final long utilitsateurId , final CreatePanierRequest request)  {
        Panier newPanier = panierMapper.dtoToEntityCreation(request);
        return panierComponent.createPanier(utilitsateurId,newPanier);
    }

    @SneakyThrows
    @Transactional
    public PanierDTO getPanier(final long id)  {
        try{
            return panierMapper.entityToDTO(panierComponent.getPanier(id));
        }catch(EntityNotFound e){
            throw new EntityNotFound("Impossible de charger l'entité panier");
        }
    }

    @SneakyThrows
    @Transactional
    public PanierDTO updatePanier(long panierId, int etatPanier){
        Panier panier = panierComponent.getPanier(panierId);
        switch(etatPanier){

            case 0 :
                panier.setEtat(EtatPanier.ANNULE);
                break ;
            case 1 :
                panier.setEtat(EtatPanier.PAYE);
                break ;
            case 2:
                panier.setEtat(EtatPanier.EN_ATTENTE);
                break ;
            case 3:
                panier.setEtat(EtatPanier.VIDE);
                break;
            default:
        }
        panierRepository.save(panier);

        return panierMapper.entityToDTO(panier);
    }
    @SneakyThrows
    @Transactional
    public List<PanierDTO> getPanierByUtilisateurId(long utilisateurId){
        List<Panier> panierList= utilisateurRepository.getPanierByUtilisateurId(utilisateurId);
        if(panierList.isEmpty()){
            throw new EntityNotFound("aucun panier trouver");
        }
        return panierMapper.entityToDTOList(panierList);
    }

    @SneakyThrows
    @Transactional
    public void setPanierUser(Long idPanier, Long idUser){
        Panier panier = panierRepository.findPanierByIdPanier(idPanier);
        panier.setUtilisateur(utilisateurRepository.getUtilisateurById(idUser));
        panierRepository.save(panier);
    }
    public byte[] generatePdf(String panierInfo) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();
        document.add(new Paragraph("Informations du Panier :\n\n" + panierInfo));
        document.add(new Paragraph("\n\nVotre panier est payé."));
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
