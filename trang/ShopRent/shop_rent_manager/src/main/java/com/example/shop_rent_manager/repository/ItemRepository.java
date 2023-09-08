package com.example.shop_rent_manager.repository;
import com.example.shop_rent_manager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}