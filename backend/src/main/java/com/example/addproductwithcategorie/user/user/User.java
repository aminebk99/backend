package com.example.addproductwithcategorie.user.user;

import com.example.addproductwithcategorie.gender.gender.Gender;
import com.example.addproductwithcategorie.situation.situation.Situation;
import com.example.addproductwithcategorie.university.university.University;
import com.example.addproductwithcategorie.work.work.Work;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String nAdherent;
    private String email;
    private String password;
    private String telephone;
    private Date dateOfBirth;
    private Date startSubscription;
    private Date endSubscription;
    private String cin;
    private String adresse;
    private Date createdAt = new Date();
    private boolean enabled = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    private Situation situation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    private University university;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    private Work work;

}
