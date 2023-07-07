package com.example.addproductwithcategorie.products.productWebService;

import com.example.addproductwithcategorie.categories.categorie.Categorie;
import com.example.addproductwithcategorie.products.product.Product;
import com.example.addproductwithcategorie.products.productService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
@CrossOrigin
@RequiredArgsConstructor
public class ProductWebService {
    private final ProductService productService;

    @PostMapping("/save/{categid}")
    public ResponseEntity<Object> saveProduct(
            @PathVariable("categid") Long categoryId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("price") Long price,
            @RequestParam("description") String description
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String uploadDir = "public/images/";
            String filePath = uploadDir + fileName;

            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            Path targetLocation = Path.of(filePath);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            Product product = Product.builder()
                    .title(title)
                    .description(description)
                    .price(price)
                    .image(fileName)

                    .build();

            Product savedProduct = productService.saveProduct(product,categoryId);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/getall")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/countproduct")
    public Long countProduct(){
        return productService.countProduct();
    }

    @GetMapping("/getid/{id}")
        public Optional<Product> getProductId(@PathVariable("id") Long id){
            return productService.getProductId(id);
        }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }


}
