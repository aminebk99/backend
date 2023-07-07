package com.example.addproductwithcategorie.categories.categorie;


import com.example.addproductwithcategorie.products.product.Product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String categname;

    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categorie")
    private Set<Product> product;

    public Categorie(Long categoryId) {
    }

    public Set<Product> getProduct(Set<Product> product){
        return product;
    }
    public void setProduct(Set<Product> product){
        this.product=product;
    }

}
