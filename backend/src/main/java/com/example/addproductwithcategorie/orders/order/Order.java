package com.example.addproductwithcategorie.orders.order;

import com.example.addproductwithcategorie.products.product.Product;

import com.example.addproductwithcategorie.user.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "`order`")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date create_at= new Date();
    private boolean confirme = false;
    private Date Startreservation;
    private Date endreservation;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
