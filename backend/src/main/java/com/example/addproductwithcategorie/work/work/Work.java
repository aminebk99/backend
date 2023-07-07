package com.example.addproductwithcategorie.work.work;

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
public class Work {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String workname;

    @OneToMany(mappedBy = "work",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("work")
    private Set<User> users;
}
