package com.example.addproductwithcategorie.work.workService;

import com.example.addproductwithcategorie.work.work.Work;
import com.example.addproductwithcategorie.work.workRepo.WorkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkService {
    private final WorkRepo workRepo;

    public List<Work> getAll(){
        return workRepo.findAll();
    }

    public Optional<Work> getId(Long id){
        return workRepo.findById(id);
    }

    public Optional<Work> getName(String name){
        return workRepo.findByWorkname(name);
    }
    public Work saveWork(Work work){
        return workRepo.save(work);
    }
    public Long countWorks(){
        return workRepo.count();
    }
}
