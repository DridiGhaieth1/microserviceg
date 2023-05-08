package tn.esprit.microservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservice.domain.entities.Categorie;
import tn.esprit.microservice.domain.entities.Produit;
import tn.esprit.microservice.services.CategorieService;
import tn.esprit.microservice.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/categorie/{id}")
    public List<Produit> getProduitsByCategorie(@PathVariable Long id) {
        return produitService.getProduitsByCategorie(id);
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return produitService.getProduitById(id);
    }

    @PostMapping("")
    public Produit saveProduit(@RequestBody Produit produit) throws ChangeSetPersister.NotFoundException {
        return produitService.saveProduit(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduitById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        produitService.deleteProduitById(id);
    }
}
