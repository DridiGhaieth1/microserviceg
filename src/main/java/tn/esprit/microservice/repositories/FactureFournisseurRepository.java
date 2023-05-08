package tn.esprit.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microservice.domain.entities.FactureFournisseur;

@Repository
public interface FactureFournisseurRepository extends JpaRepository<FactureFournisseur,Long> {
    FactureFournisseur findFactureFournisseurByCode(String code);
}
