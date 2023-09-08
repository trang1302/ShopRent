package com.example.shop_rent_manager.repository;
import com.example.shop_rent_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}