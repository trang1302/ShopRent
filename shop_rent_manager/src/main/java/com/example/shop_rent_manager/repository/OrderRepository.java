package com.example.shop_rent_manager.repository;

import com.example.shop_rent_manager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}