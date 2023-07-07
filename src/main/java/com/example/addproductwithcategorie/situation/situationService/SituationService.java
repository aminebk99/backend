package com.example.addproductwithcategorie.situation.situationService;

import com.example.addproductwithcategorie.situation.situation.Situation;
import com.example.addproductwithcategorie.situation.situationRepo.SituationRepo;
import com.example.addproductwithcategorie.university.university.University;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SituationService {
    private final SituationRepo situationRepo;

    public List<Situation> getAll(){
        return situationRepo.findAll();
    }

    public Optional<Situation> getId(Long id){
        return situationRepo.findById(id);
    }
    public Optional<Situation> getName(String name){
        Situation existingsituaction = situationRepo.findBySituationname(name);
        return Optional.ofNullable(existingsituaction);

    }
    public Situation saveSituation(Situation situation){
        return situationRepo.save(situation);
    }
}
