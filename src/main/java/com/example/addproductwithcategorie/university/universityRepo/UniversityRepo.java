package com.example.addproductwithcategorie.university.universityRepo;

import com.example.addproductwithcategorie.university.university.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {

    Optional<University> findByUniversityname(String name);
}
