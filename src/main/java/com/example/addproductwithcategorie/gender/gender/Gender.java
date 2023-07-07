package com.example.addproductwithcategorie.gender.gender;


import com.example.addproductwithcategorie.user.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gendername;

    @OneToMany(mappedBy = "gender",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("gender")
    private Set<User> users;

}
