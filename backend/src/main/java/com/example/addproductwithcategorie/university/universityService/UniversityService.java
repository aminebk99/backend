package com.example.addproductwithcategorie.university.universityService;

import com.example.addproductwithcategorie.university.university.University;
import com.example.addproductwithcategorie.university.universityRepo.UniversityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepo universityRepo;

    public List<University> getAll(){
        return universityRepo.findAll();
    }
    public Optional<University> getName(String name){
        return universityRepo.findByUniversityname(name);
    }

    public Optional<University> getId(Long id){
        return universityRepo.findById(id);
    }

    public Long countUniversity(){
        return universityRepo.count();
    }

    public String saveUniversity(University university, String name){
        Optional<University> existingname = universityRepo.findByUniversityname(name);
        if (existingname.isPresent()){
            return ("this name already used");
        }
        else{
            universityRepo.save(university);
            return ("Name of University "+existingname+"this added with successefuly");
        }
    }
}
