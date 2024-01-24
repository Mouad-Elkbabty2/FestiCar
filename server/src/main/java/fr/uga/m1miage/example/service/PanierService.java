package fr.uga.m1miage.example.service;

import fr.uga.m1miage.example.Component.PanierComponent;
import fr.uga.m1miage.example.Exception.EntityNotFound;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PanierService {

    private final PanierComponent panierComponent ;

    @SneakyThrows
    @Transactional
    public void deletePanier(final long id)  {
        try {
            panierComponent.deletePanier(id);
        } catch (EntityNotFound ex) {
            throw new EntityNotFound("Impossible de supprimer l'entité.");
        }
    }
}
