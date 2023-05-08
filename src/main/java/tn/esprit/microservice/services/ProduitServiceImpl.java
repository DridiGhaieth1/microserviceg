package tn.esprit.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import tn.esprit.microservice.domain.entities.Categorie;
import tn.esprit.microservice.domain.entities.Produit;
import tn.esprit.microservice.repositories.CategorieRepository;
import tn.esprit.microservice.repositories.ProduitRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProduitsByCategorie(Long categorieId) {
        return produitRepository.findByCategorieId(categorieId);
    }

    @Override
    public Produit getProduitById(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isPresent()) {
            return optionalProduit.get();
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @Override
    public Produit saveProduit(Produit produit) throws ChangeSetPersister.NotFoundException {
        Categorie categorie = categorieRepository.findById(produit.getCategorie().getId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        produit.setCategorie(categorie);
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduitById(Long id) throws ChangeSetPersister.NotFoundException {
        if (!produitRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        produitRepository.deleteById(id);
    }

}


