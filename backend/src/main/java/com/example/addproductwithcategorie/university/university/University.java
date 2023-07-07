package com.example.addproductwithcategorie.university.university;


import com.example.addproductwithcategorie.user.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String universityname;

    @OneToMany(mappedBy = "university",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;
}
