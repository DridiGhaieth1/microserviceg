package tn.esprit.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservice.domain.dtos.FactureClientDTO;
import tn.esprit.microservice.domain.dtos.FactureFournisseurDTO;
import tn.esprit.microservice.services.FactureFournisseurService;

import java.util.List;

@Controller
public class FactureFournisseurController {
    @Autowired
    FactureFournisseurService factureFournisseurService;

    @GetMapping("/")
    public List<FactureFournisseurDTO> getAllFactureFournisseurs() {
        return factureFournisseurService.getFactureFournisseurs();
    }

    @PostMapping("/")
    public void createFactureFournisseur(@RequestBody FactureFournisseurDTO factureFournisseur) {
        factureFournisseurService.add(factureFournisseur);
    }
    @PutMapping("/{code}")
    public void updateFactureFournisseur(@PathVariable("code") String code, @RequestBody FactureFournisseurDTO factureFournisseur) {
        factureFournisseurService.update(code,factureFournisseur);
    }

    @DeleteMapping("/{code}")
    public void deleteFactureFournisseur(@PathVariable("code") String code) {
        factureFournisseurService.delete(code);
    }
}
