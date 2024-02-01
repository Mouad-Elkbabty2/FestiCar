package fr.uga.m1miage.example.controller;


import fr.uga.m1miage.example.endpoint.PanierEndPoint;
import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.request.CreatePanierRequest;
import fr.uga.m1miage.example.response.PanierDTO;
import fr.uga.m1miage.example.service.PanierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class PanierController implements PanierEndPoint {
    private final PanierService panierService ;
    @Override
    public void deletePanier(long id) {
        panierService.deletePanier(id);
    }

    @Override
    public PanierDTO createPanier(long utilisateurId, CreatePanierRequest createPanierRequest)  {
        return panierService.createPanier(utilisateurId,createPanierRequest);
    }

    @Override
    public PanierDTO getPanierById(Long id) {
        return panierService.getPanier(id);
    }

    @Override
    public List<PanierDTO> getPanierByUtilisateur(long utilisateurId) {
        return panierService.getPanierByUtilisateurId(utilisateurId);
    }

    @Override
    public PanierDTO setPanierEtat(long panierId, int etatPanier) {
        return panierService.updatePanier(panierId,etatPanier);
    }

  /*  @Override
    public void setPanierUser(long panierId, long userId) {
        panierService.setPanierUser(panierId,userId);
    }*/
  public ResponseEntity<byte[]> generatePdf(@PathVariable long panierId) {
      // TODO: Ajoutez votre logique pour vérifier si le panier est payé et récupérez les informations du panier.

      PanierDTO panier = panierService.getPanier(panierId);
      String panierInfo = "le panier d'id " + panier.getIdPanier() + " et d'utilisateur " + panier.getUtilisateur().getNom() + "est payé";

      try {
          byte[] pdfBytes = panierService.generatePdf(panierInfo);

          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(MediaType.APPLICATION_PDF);
          headers.add("Content-Disposition", "inline; filename=panier.pdf");

          return ResponseEntity.ok().headers(headers).body(pdfBytes);
      } catch (DocumentException e) {
          e.printStackTrace();
          return ResponseEntity.status(500).body(null);
      }
  }

}
