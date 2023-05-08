package tn.esprit.microservice.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import tn.esprit.microservice.domain.entities.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits();

    List<Produit> getProduitsByCategorie(Long categorieId);

    Produit getProduitById(Long id) throws ChangeSetPersister.NotFoundException;

    Produit saveProduit(Produit produit) throws ChangeSetPersister.NotFoundException;

    void deleteProduitById(Long id) throws ChangeSetPersister.NotFoundException;

}
