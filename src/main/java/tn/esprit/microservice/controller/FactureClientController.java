package tn.esprit.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservice.domain.dtos.FactureClientDTO;
import tn.esprit.microservice.services.FactureClientService;
import java.util.List;

@Controller
public class FactureClientController {
    @Autowired
    FactureClientService factureClientService;

    @GetMapping("/")
    public List<FactureClientDTO> getAllFactureClients() {
        return factureClientService.getFactureClients();
    }

    @PostMapping("/")
    public void createFactureClient(@RequestBody FactureClientDTO factureClient) {
         factureClientService.add(factureClient);
    }
    @PutMapping("/{code}")
    public void updateFactureClient(@PathVariable("code") String code, @RequestBody FactureClientDTO factureClient) {
        factureClientService.update(code,factureClient);
    }

    @DeleteMapping("/{code}")
    public void deleteFactureClient(@PathVariable("code") String code) {
        factureClientService.delete(code);
    }
}

