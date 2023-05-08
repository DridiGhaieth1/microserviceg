package tn.esprit.microservice.services;

import tn.esprit.microservice.domain.dtos.FactureFournisseurDTO;

import java.util.List;

public interface FactureFournisseurService {
    void add(FactureFournisseurDTO factureFournisseurDTO);
    void update(String code,FactureFournisseurDTO factureFournisseurDTO);
    void delete (String code );
    List<FactureFournisseurDTO> getFactureFournisseurs();
}
