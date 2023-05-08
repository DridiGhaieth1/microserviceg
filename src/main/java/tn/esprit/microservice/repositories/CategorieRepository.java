package tn.esprit.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microservice.domain.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}

