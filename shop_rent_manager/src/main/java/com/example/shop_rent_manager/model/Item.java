package com.example.shop_rent_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Repo> repositories;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders;


}
