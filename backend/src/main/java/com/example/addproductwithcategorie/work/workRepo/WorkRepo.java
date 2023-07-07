package com.example.addproductwithcategorie.work.workRepo;

import com.example.addproductwithcategorie.work.work.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkRepo extends JpaRepository<Work, Long> {
    Optional<Work> findByWorkname(String name);
}
