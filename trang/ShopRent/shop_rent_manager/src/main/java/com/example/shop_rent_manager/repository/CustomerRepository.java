package com.example.shop_rent_manager.repository;
import com.example.shop_rent_manager.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}