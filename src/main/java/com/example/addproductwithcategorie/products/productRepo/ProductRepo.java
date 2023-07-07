package com.example.addproductwithcategorie.products.productRepo;

import com.example.addproductwithcategorie.products.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product , Long> {
}
