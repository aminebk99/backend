package com.example.addproductwithcategorie.user.userWebService;

import com.example.addproductwithcategorie.gender.gender.Gender;
import com.example.addproductwithcategorie.gender.genderRepo.GenderRepo;
import com.example.addproductwithcategorie.situation.situation.Situation;
import com.example.addproductwithcategorie.situation.situationRepo.SituationRepo;
import com.example.addproductwithcategorie.university.university.University;
import com.example.addproductwithcategorie.university.universityRepo.UniversityRepo;
import com.example.addproductwithcategorie.user.user.User;
import com.example.addproductwithcategorie.user.userRepo.UserRepo;
import com.example.addproductwithcategorie.user.userService.UserService;
import com.example.addproductwithcategorie.work.work.Work;
import com.example.addproductwithcategorie.work.workRepo.WorkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserWebService {
    private final UserService userService;
    private final GenderRepo genderRepo;
    private final WorkRepo workRepo;
    private final UniversityRepo universityRepo;
    private final SituationRepo situationRepo;
    private final UserRepo userRepo;

    @GetMapping("/getall")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/save/{genderid}/{situationid}/{workid}/{universityid}")
    public User saveUser(@RequestBody User user,@PathVariable("genderid")Long genderid,@PathVariable("situationid")Long situationid,@PathVariable("workid")Long workid,@PathVariable("universityid")Long universityid){
        return userService.saveUser(user,genderid,situationid,workid,universityid);
    }
    @GetMapping("/getid/{id}")
    public Optional<User> getUserId(@PathVariable("id") Long id){
        return userService.getUserId(id);
    }
    @GetMapping("/getemail/{email}")
    public Optional<User> getUserEmail(@PathVariable("email") String email){
        return userService.getUserEmail(email);
    }
    @PutMapping("/actived/{userId}")
    public String activeUser(@PathVariable("userId") Long userId){
        userService.userActived(userId);
        return("Is Done");
    }

    @PutMapping("/updateuser/{id}/{genderid}/{situationid}/{workid}/{universityid}")
    public User updateUser(@PathVariable("id") Long id,
                                           @PathVariable("genderid") Long genderid,
                                           @PathVariable("situationid") Long situationid,
                                           @PathVariable("workid") Long workid,
                                           @PathVariable("universityid") Long universityid,
                                           @RequestBody User user) {

       return userService.updateUsers(id,genderid,situationid,workid,universityid,user);
    }


    @GetMapping("/countusers")
    public Long countUsers(){
        return userService.countUsers();
    }

    @PutMapping("/desactived/{id}")
    public String desactiveUser(@PathVariable("id")Long id){
        userService.userDesactived(id);
        return ("Account is No Active !");
    }

}
