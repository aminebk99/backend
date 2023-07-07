package com.example.addproductwithcategorie.gender.genderRepo;

import com.example.addproductwithcategorie.gender.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface GenderRepo extends JpaRepository<Gender, Long> {

    Optional<Gender> findByGendernameIgnoreCase(String genderName);
}
