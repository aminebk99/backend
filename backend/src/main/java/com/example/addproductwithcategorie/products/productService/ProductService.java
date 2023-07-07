package com.example.addproductwithcategorie.products.productService;

import com.example.addproductwithcategorie.categories.categorie.Categorie;
import com.example.addproductwithcategorie.categories.categorieRepo.CategorieRepo;
import com.example.addproductwithcategorie.products.product.Product;
import com.example.addproductwithcategorie.products.productRepo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class ProductService {
    private final ProductRepo productRepo;
    private final CategorieRepo categorieRepo;

    public ProductService(ProductRepo productRepo, CategorieRepo categorieRepo) {
        this.productRepo = productRepo;
        this.categorieRepo = categorieRepo;
    }


    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product saveProduct(Product product, Long categid) {
        Optional<Categorie> categorieOptional = categorieRepo.findById(categid);
        if (categorieOptional.isPresent()) {
            Categorie categorie = categorieOptional.get();
            product.setCategorie(categorie);
            return productRepo.save(product);
        } else {
            throw new IllegalArgumentException("Invalid category ID");
        }
    }

    public void deleteProduct(Long id){
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()){
            productRepo.deleteById(id);
        }

    }


    public Optional<Product> getProductId(Long id){
        return productRepo.findById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductId(id).orElse(null);

        if (product != null) {
            product.setTitle(updatedProduct.getTitle());
            product.setPrice(updatedProduct.getPrice());
            product.setDescription(updatedProduct.getDescription());
            return productRepo.save(product);
        }

        return null;
    }
    public Long countProduct(){
        return productRepo.count();
    }
}
