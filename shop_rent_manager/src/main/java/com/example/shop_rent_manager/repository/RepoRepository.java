package com.example.shop_rent_manager.repository;

import com.example.shop_rent_manager.model.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoRepository extends JpaRepository<Repo, Long> {
    List<Repo> findByShopId(Long shopId);
}