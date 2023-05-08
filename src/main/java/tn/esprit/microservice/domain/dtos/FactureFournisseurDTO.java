package tn.esprit.microservice.domain.dtos;

import lombok.Builder;
import lombok.Data;
import tn.esprit.microservice.domain.entities.FactureClient;
import tn.esprit.microservice.domain.entities.FactureFournisseur;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class FactureFournisseurDTO implements Serializable {
    private String code;
    private String description;
    private Date dateFacture;
    private Date datePayement;
    private int nombreArticle;
    private double prixTotal;
    public FactureFournisseur toEntity() {
        return FactureFournisseur.builder().code(code).dateFacture(dateFacture)
                .datePayement(datePayement)
                .description(description)
                .nombreArticle(nombreArticle)
                .prixTotal(prixTotal).build();
    }
}
