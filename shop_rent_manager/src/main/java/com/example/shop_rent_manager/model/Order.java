package com.example.shop_rent_manager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private int amount_order;





    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @JsonIgnore
    private List<Item> items;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private Customer customer;

}
