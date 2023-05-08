package tn.esprit.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservice.domain.dtos.FactureClientDTO;
import tn.esprit.microservice.domain.entities.FactureClient;
import tn.esprit.microservice.repositories.FactureClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureClientServiceImpl implements FactureClientService{

    @Autowired
    FactureClientRepository factureClientRepository;
    @Override
    public void add(FactureClientDTO factureClientDTO) {
        factureClientRepository.save(factureClientDTO.toEntity());
    }

    @Override
    public void update(String code, FactureClientDTO factureClientDTO) {
        FactureClient factureClient = factureClientRepository.findFactureClientByCode(factureClientDTO.getCode());
        if (factureClient==null) {
            return;
        }
        factureClient = factureClientDTO.toEntity();
        factureClientRepository.save(factureClient);
    }

    @Override
    public void delete(String code) {
        FactureClient factureClient = factureClientRepository.findFactureClientByCode(code);
        factureClientRepository.delete(factureClient);
    }

    @Override
    public List<FactureClientDTO> getFactureClients() {
        return factureClientRepository.findAll().stream().map(e->e.toDto()).collect(Collectors.toList());
    }
}
