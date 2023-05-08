package tn.esprit.microservice.domain.dtos;

import lombok.Builder;
import lombok.Data;
import tn.esprit.microservice.domain.entities.FactureClient;

import java.util.Date;

@Data
@Builder
public class FactureClientDTO {

    private String code;
    private String description;
    private Date dateFacture;
    private Date datePayement;
    private int nombreArticle;
    private double prixTotal;

    public FactureClient toEntity() {
        return FactureClient.builder().code(code).dateFacture(dateFacture)
                .datePayement(datePayement)
                .description(description)
                .nombreArticle(nombreArticle)
                .prixTotal(prixTotal).build();
    }
}
