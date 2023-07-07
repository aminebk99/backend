package com.example.addproductwithcategorie.situation.situationRepo;

import com.example.addproductwithcategorie.situation.situation.Situation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituationRepo extends JpaRepository<Situation, Long> {
    Situation findBySituationname(String name);
}
