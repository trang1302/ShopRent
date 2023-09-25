package com.example.shop_rent_manager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String amount_left;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<Repo> repositories;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<Order> orders;


}
