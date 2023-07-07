package com.example.addproductwithcategorie.categories.categorieService;

import com.example.addproductwithcategorie.categories.categorie.Categorie;
import com.example.addproductwithcategorie.categories.categorieRepo.CategorieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategorieService {
    private final CategorieRepo categorieRepo;

    public Categorie saveCategorie(Categorie categorie){
        return categorieRepo.save(categorie);
    }

    public List<Categorie> getAllCategorie(){
        return categorieRepo.findAll();
    }
    public Optional<Categorie> getCategorieId(Long id){
        return categorieRepo.findById(id);
    }


    public Long countCateg(){
        return categorieRepo.count();
    }

}
