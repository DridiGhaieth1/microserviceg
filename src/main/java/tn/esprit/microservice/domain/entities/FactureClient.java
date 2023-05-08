package tn.esprit.microservice.domain.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.microservice.domain.dtos.FactureClientDTO;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FactureClient extends Facture implements Serializable {
    @Builder
    public FactureClient(Long id, String code, String description, Date dateFacture, Date datePayement, int nombreArticle, double prixTotal) {
        super(id, code, description, dateFacture, datePayement, nombreArticle, prixTotal);
    }

    public FactureClientDTO toDto(){
        return FactureClientDTO.builder().description(getDescription())
                .dateFacture(getDateFacture()).datePayement(getDatePayement())
                .nombreArticle(getNombreArticle())
                .prixTotal(getPrixTotal())
                .build();
    }
}
