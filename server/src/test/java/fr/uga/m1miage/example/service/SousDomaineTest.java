package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.models.Domaine;
import fr.uga.m1miage.example.models.SousDomaine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class SousDomaineTest {

    @Test
     void testGetterSetter() {
        SousDomaine sousDomaine = new SousDomaine();
        sousDomaine.setNomSousDomaine("TestSousDomaine");

        Domaine domaine = new Domaine();
        domaine.setNomDomaine("1L");
        domaine.setNomDomaine("TestDomaine");
        sousDomaine.setDomaine(domaine);

        assertEquals("TestSousDomaine", sousDomaine.getNomSousDomaine());
        assertEquals(domaine, sousDomaine.getDomaine());
    }


}
