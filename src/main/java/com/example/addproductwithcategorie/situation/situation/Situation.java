package com.example.addproductwithcategorie.situation.situation;

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
public class Situation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String situationname;

    @OneToMany(mappedBy = "situation",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("situation")
    private Set<User> users;
}
