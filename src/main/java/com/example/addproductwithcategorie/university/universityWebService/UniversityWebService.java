package com.example.addproductwithcategorie.university.universityWebService;

import com.example.addproductwithcategorie.university.university.University;
import com.example.addproductwithcategorie.university.universityService.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/university")
@RequiredArgsConstructor
public class UniversityWebService {
    private final UniversityService universityService;

    @GetMapping("getall")
    public List<University> getall(){
        return universityService.getAll();
    }

    @GetMapping("/getname/{name}")
    public Optional<University> getname(@PathVariable("id")String name){
        return universityService.getName(name);
    }

    @GetMapping("/getid/{id}")
    public Optional<University> getname(@PathVariable("id")Long id){
        return universityService.getId(id);
    }

    @PostMapping("/save")
    public String saveUniversity(@RequestBody University university,@RequestParam String name){
        universityService.saveUniversity(university,name);
        return ("added with successefuly");
    }
    @GetMapping("/countuniversity")
    public Long countUniversity(){
        return universityService.countUniversity();
    }
}
