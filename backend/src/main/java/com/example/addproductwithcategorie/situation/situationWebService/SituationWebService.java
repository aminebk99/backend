package com.example.addproductwithcategorie.situation.situationWebService;

import com.example.addproductwithcategorie.situation.situation.Situation;
import com.example.addproductwithcategorie.situation.situationService.SituationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/situation")
public class SituationWebService {
    private final SituationService situationService;

    @GetMapping("/getall")
    public List<Situation> getAll(){
        return situationService.getAll();
    }

    @GetMapping("/getid/{id}")
    public Optional<Situation> getId(@PathVariable("id")Long id){
        return situationService.getId(id);
    }
    @GetMapping("/getname/{name}")
    public Optional<Situation> getName(@PathVariable("name")String name){
        return situationService.getName(name);
    }

    @PostMapping("/save")
    public Situation saveUniversity(@RequestBody Situation situation){
        return situationService.saveSituation(situation);
    }
}
