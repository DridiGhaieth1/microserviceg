package tn.esprit.microservice.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.microservice.domain.dtos.FactureClientDTO;
import tn.esprit.microservice.domain.dtos.FactureFournisseurDTO;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FactureFournisseur extends Facture implements Serializable {
    @Builder
    public FactureFournisseur(Long id, String code, String description, Date dateFacture, Date datePayement, int nombreArticle, double prixTotal) {
        super(id, code, description, dateFacture, datePayement, nombreArticle, prixTotal);
    }



    public FactureFournisseurDTO toDto(){
        return FactureFournisseurDTO.builder().code(getCode()).description(getDescription())
                .dateFacture(getDateFacture()).datePayement(getDatePayement())
                .nombreArticle(getNombreArticle())
                .prixTotal(getPrixTotal())
                .build();
    }
}
