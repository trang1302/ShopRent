package com.example.shop_rent_manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "repository_item")
public class RepoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ItemPerRepo;
    @ManyToOne
    @JoinColumn(name="repository_id")
    private Repo repo;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
