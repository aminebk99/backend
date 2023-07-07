package com.example.addproductwithcategorie.products.product;

import com.example.addproductwithcategorie.categories.categorie.Categorie;

import com.example.addproductwithcategorie.orders.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long price;
    private String image;


    @ManyToOne(fetch = FetchType.EAGER)
    private Categorie categorie;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("product")
    private Set<Order> order;

    public Set<Order> getOrder(Set<Order> order){
        return order;
    }
    public void setOrder(Set<Order> order){
        this.order = order;
    }





}
