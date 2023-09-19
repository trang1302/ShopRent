package com.example.shop_rent_manager.repository;

import com.example.shop_rent_manager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM items " +
            "INNER JOIN order_item ON items.id = order_item.item_id " +
            "WHERE items.name LIKE %:keyword%", nativeQuery = true)
    public List<Item> search(@Param("keyword") String keyword);
}