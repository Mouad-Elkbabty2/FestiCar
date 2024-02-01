package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.models.Panier;
import fr.uga.m1miage.example.models.TypeUtilisateur;
import fr.uga.m1miage.example.models.Utilisateur;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurTest {

    @Test
    void testGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setNom("Doe");
        utilisateur.setPrenom("John");
        utilisateur.setTelephone("123456789");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMdp("password");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.PASSAGER);

        assertEquals(1L, utilisateur.getId());
        assertEquals("Doe", utilisateur.getNom());
        assertEquals("John", utilisateur.getPrenom());
        assertEquals("123456789", utilisateur.getTelephone());
        assertEquals("john.doe@example.com", utilisateur.getEmail());
        assertEquals("password", utilisateur.getMdp());
        assertEquals(TypeUtilisateur.PASSAGER, utilisateur.getTypeUtilisateur());
    }

    @Test
    void testPanierManipulation() {
        Utilisateur utilisateur = new Utilisateur();
        Panier panier1 = new Panier();
        Panier panier2 = new Panier();

        List<Panier> panierList = new ArrayList<>();
        utilisateur.setPanier(panierList);
        utilisateur.getPanier().add(panier1);
        utilisateur.getPanier().add(panier2);

        assertEquals(2, utilisateur.getPanier().size());

    }
    @Test
    void testIdGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        assertEquals(1L, utilisateur.getId());
    }

    @Test
    void testNomGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Doe");
        assertEquals("Doe", utilisateur.getNom());
    }

    @Test
    void testPrenomGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom("John");
        assertEquals("John", utilisateur.getPrenom());
    }

    @Test
    void testTelephoneGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setTelephone("123456789");
        assertEquals("123456789", utilisateur.getTelephone());
    }

    @Test
    void testEmailGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", utilisateur.getEmail());
    }

    @Test
    void testMdpGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMdp("password");
        assertEquals("password", utilisateur.getMdp());
    }

    @Test
    void testTypeUtilisateurGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setTypeUtilisateur(TypeUtilisateur.PASSAGER);
        assertEquals(TypeUtilisateur.PASSAGER, utilisateur.getTypeUtilisateur());
    }
    @Test
     void testGetterSetter() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setTelephone("123456789");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMdp("password");
        utilisateur.setPanier(List.of());
        utilisateur.setTypeUtilisateur(TypeUtilisateur.CONDUCTEUR);

        assertEquals(1L, utilisateur.getId());
        assertEquals("John", utilisateur.getNom());
        assertEquals("Doe", utilisateur.getPrenom());
        assertEquals("123456789", utilisateur.getTelephone());
        assertEquals("john.doe@example.com", utilisateur.getEmail());
        assertEquals("password", utilisateur.getMdp());
        assertEquals(TypeUtilisateur.CONDUCTEUR, utilisateur.getTypeUtilisateur());
    }






}

