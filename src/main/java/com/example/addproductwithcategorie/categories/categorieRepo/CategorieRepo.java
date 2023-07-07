package com.example.addproductwithcategorie.categories.categorieRepo;

import com.example.addproductwithcategorie.categories.categorie.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Long> {


}
