package br.edu.ifpb.gps.unova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private Long productId;
    private String name;
    private Double price;
    private int quantity;
    private String imageUrl;

    @Version
    private int version;// Adicionando controle de versão
}
