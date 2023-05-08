package tn.esprit.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservice.domain.dtos.FactureFournisseurDTO;
import tn.esprit.microservice.domain.entities.FactureFournisseur;
import tn.esprit.microservice.repositories.FactureFournisseurRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureFournisseurImpl implements FactureFournisseurService{

    @Autowired
    FactureFournisseurRepository factureFournisseurRepository;
    @Override
    public void add(FactureFournisseurDTO factureFournisseurDTO) {
        factureFournisseurRepository.save(factureFournisseurDTO.toEntity());
    }

    @Override
    public void update(String code, FactureFournisseurDTO factureFournisseurDTO) {
        FactureFournisseur factureFournisseur = factureFournisseurRepository.findFactureFournisseurByCode(factureFournisseurDTO.getCode());
        if (factureFournisseur==null) {
            return;
        }
        factureFournisseur = factureFournisseurDTO.toEntity();
        factureFournisseurRepository.save(factureFournisseur);
    }

    @Override
    public void delete(String code) {
        FactureFournisseur factureFournisseur = factureFournisseurRepository.findFactureFournisseurByCode(code);
        factureFournisseurRepository.delete(factureFournisseur);
    }

    @Override
    public List<FactureFournisseurDTO> getFactureFournisseurs() {
        return factureFournisseurRepository.findAll().stream().map(e->e.toDto()).collect(Collectors.toList());
    }
}
