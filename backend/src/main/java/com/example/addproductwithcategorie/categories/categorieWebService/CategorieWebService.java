package com.example.addproductwithcategorie.categories.categorieWebService;


import com.example.addproductwithcategorie.categories.categorie.Categorie;
import com.example.addproductwithcategorie.categories.categorieService.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categ")
@CrossOrigin
public class CategorieWebService {
    private final CategorieService categorieService;

    public CategorieWebService(CategorieService categorieService) {
        this.categorieService = categorieService;
    }
    @PostMapping("/save")
    public Categorie saveCategorie(@RequestBody Categorie categorie){
        return categorieService.saveCategorie(categorie);
    }
    @GetMapping("/getall")
    public List<Categorie> getAllCategorie(){
        return categorieService.getAllCategorie();
    }

    @GetMapping("/countcategorie")
    public Long countCateg(){
        return categorieService.countCateg();
    }

    @GetMapping("getid/{id}")
    public Optional<Categorie> getId( @PathVariable("id") Long id){
        return categorieService.getCategorieId(id);
    }


}
