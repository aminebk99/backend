package com.example.addproductwithcategorie.gender.genderWebService;

import com.example.addproductwithcategorie.gender.gender.Gender;
import com.example.addproductwithcategorie.gender.genderService.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/gender")
public class GenderWebService {
    private final GenderService genderService;

    @GetMapping("/getall")
    public List<Gender> getAll(){
        return genderService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveGender(@RequestBody Gender gender) {
        String message = genderService.saveGender(gender);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
    @GetMapping("/getid/{id}")
    public Optional<Gender> getId(@PathVariable("id") Long id){
        return genderService.getId(id);
    }

    @GetMapping("/getname/{name}")
    public Optional<Gender> getName(@PathVariable("name")String name){
        return genderService.getName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGender(@PathVariable("id") Long id) {
        String message = genderService.deleteGender(id);
        return ResponseEntity.ok(message);
    }

}
