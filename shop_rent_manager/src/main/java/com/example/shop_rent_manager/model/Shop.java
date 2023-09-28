package com.example.shop_rent_manager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    
    @ManyToMany(mappedBy = "shops")
    @JsonIgnore
    private List<User> users;
    
    @OneToMany
    @JsonIgnore
    private List<Repo> repositories;


}

