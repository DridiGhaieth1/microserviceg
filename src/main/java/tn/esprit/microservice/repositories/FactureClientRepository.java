package tn.esprit.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.microservice.domain.entities.FactureClient;

@Repository
public interface FactureClientRepository extends JpaRepository<FactureClient,Long> {
    FactureClient findFactureClientByCode(String code);
}
