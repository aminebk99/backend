package com.example.addproductwithcategorie.work.workWebServcie;

import com.example.addproductwithcategorie.work.work.Work;
import com.example.addproductwithcategorie.work.workService.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/work")
public class WorkWebServcie {
    private final WorkService workServcie;

    @GetMapping("/getall")
    public List<Work> getAll(){
        return workServcie.getAll();
    }

    @GetMapping("/getid/{id}")
    public Optional<Work> getId(@PathVariable("id")Long id){
        return workServcie.getId(id);
    }

    @GetMapping("/getname/{name}")
    public Optional<Work> getName(@PathVariable("name") String name){
        return workServcie.getName(name);
    }

    @GetMapping("/countwork")
    public Long countWorks(){
        return workServcie.countWorks();
    }
    @PostMapping("/save")
    public Work saveWork(@RequestBody Work work){
        return workServcie.saveWork(work);
    }
}
