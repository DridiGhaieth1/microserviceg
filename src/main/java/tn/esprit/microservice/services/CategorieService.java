package tn.esprit.microservice.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import tn.esprit.microservice.domain.entities.Categorie;

import java.util.List;

public interface CategorieService {

    List<Categorie> getAllCategories();

    Categorie getCategorieById(Long id) throws ChangeSetPersister.NotFoundException;

    Categorie saveCategorie(Categorie categorie);

    void deleteCategorieById(Long id);

}
