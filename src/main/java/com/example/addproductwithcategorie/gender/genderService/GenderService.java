package com.example.addproductwithcategorie.gender.genderService;

import com.example.addproductwithcategorie.gender.gender.Gender;
import com.example.addproductwithcategorie.gender.genderRepo.GenderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenderService {
    private final GenderRepo genderRepo;

    public List<Gender> getAll(){
        return genderRepo.findAll();
    }

    public Optional<Gender> getId(Long id){
        return genderRepo.findById(id);
    }

    public Optional<Gender> getName (String name){
        return genderRepo.findByGendernameIgnoreCase(name);
    }

    public String saveGender(Gender gender) {
        Optional<Gender> existingGender = genderRepo.findByGendernameIgnoreCase(gender.getGendername());
        if (existingGender.isPresent()) {
            return "The gender with name " + gender.getGendername() + " already exists.";
        } else {
            genderRepo.save(gender);
            return "Gender " + gender.getGendername() + " added successfully.";
        }
    }

    public String deleteGender(Long id) {
        Optional<Gender> existingGender = genderRepo.findById(id);
        if (existingGender.isPresent()) {
            genderRepo.delete(existingGender.get());
            return "Gender deleted successfully.";
        } else {
            return "Gender not found.";
        }
    }


}
