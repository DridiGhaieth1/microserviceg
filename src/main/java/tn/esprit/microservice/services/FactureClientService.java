package tn.esprit.microservice.services;

import tn.esprit.microservice.domain.dtos.FactureClientDTO;

import java.util.List;

public interface FactureClientService {
    void add(FactureClientDTO factureClientDTO);
    void update(String code,FactureClientDTO factureClientDTO);
    void delete (String code );
    List<FactureClientDTO> getFactureClients();
}
