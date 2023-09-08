package com.example.shop_rent_manager.repository;

import com.example.shop_rent_manager.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}