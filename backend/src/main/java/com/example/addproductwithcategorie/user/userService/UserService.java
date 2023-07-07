package com.example.addproductwithcategorie.user.userService;

import com.example.addproductwithcategorie.gender.gender.Gender;
import com.example.addproductwithcategorie.gender.genderRepo.GenderRepo;
import com.example.addproductwithcategorie.situation.situation.Situation;
import com.example.addproductwithcategorie.situation.situationRepo.SituationRepo;
import com.example.addproductwithcategorie.university.university.University;
import com.example.addproductwithcategorie.university.universityRepo.UniversityRepo;
import com.example.addproductwithcategorie.user.user.User;
import com.example.addproductwithcategorie.user.userRepo.UserRepo;
import com.example.addproductwithcategorie.work.work.Work;
import com.example.addproductwithcategorie.work.workRepo.WorkRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final WorkRepo workRepo;
    private final UniversityRepo universityRepo;
    private final GenderRepo genderRepo;
    private final SituationRepo situationRepo;


    public User saveUser(User user,Long genderId, Long situationId, Long workId, Long universityId){
        Optional<Gender> genderOptional = genderRepo.findById(genderId);
        Optional<Situation> situationOptional = situationRepo.findById(situationId);
        Optional<Work> workOptional = workRepo.findById(workId);
        Optional<University> universityOptional = universityRepo.findById(universityId);



        if (genderOptional.isPresent() && situationOptional.isPresent() && workOptional.isPresent() && universityOptional.isPresent())
        {
            Gender gender = genderOptional.get();
            Work work = workOptional.get();
            Situation situation=situationOptional.get();
            University university = universityOptional.get();

            user.setGender(gender);
            user.setWork(work);
            user.setSituation(situation);
            user.setUniversity(university);

        }
        return userRepo.save(user);

    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserEmail(String email){
        return userRepo.findByEmail(email);
    }
    public Optional<User> getUserId(Long id){
        return userRepo.findById(id);
    }
    public void userActived(Long id){
        User user = userRepo.findById(id)
                        .orElseThrow();
        user.setEnabled(true);
        userRepo.save(user);
    }
    public void userDesactived(Long id){
        User user = userRepo.findById(id)
                .orElseThrow();
        user.setEnabled(false);
        userRepo.save(user);
    }
    public Long countUsers(){
        return userRepo.count();
    }

    public User updateUsers(Long id, Long genderId, Long situationId, Long workId, Long universityId, User user) {
        Optional<Gender> genderOptional = genderRepo.findById(genderId);
        Optional<Situation> situationOptional = situationRepo.findById(situationId);
        Optional<Work> workOptional = workRepo.findById(workId);
        Optional<University> universityOptional = universityRepo.findById(universityId);

        if (genderOptional.isPresent() && situationOptional.isPresent() && workOptional.isPresent() && universityOptional.isPresent()) {
            Gender gender = genderOptional.get();
            Work work = workOptional.get();
            Situation situation = situationOptional.get();
            University university = universityOptional.get();

            Optional<User> userOptional = userRepo.findById(id);

            if (userOptional.isPresent()) {
                User existUser = userOptional.get();

                existUser.setFirstname(user.getFirstname());
                existUser.setLastname(user.getLastname());
                existUser.setNAdherent(user.getNAdherent());
                existUser.setTelephone(user.getTelephone());
                existUser.setAdresse(user.getAdresse());
                existUser.setCin(user.getCin());
                existUser.setEmail(user.getEmail());
                existUser.setGender(gender);
                existUser.setWork(work);
                existUser.setSituation(situation);
                existUser.setUniversity(university);

                return userRepo.save(existUser);
            }
        }

        return null;
    }

}
