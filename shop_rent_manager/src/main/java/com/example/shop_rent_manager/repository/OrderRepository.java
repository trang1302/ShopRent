package com.example.shop_rent_manager.repository;

import com.example.shop_rent_manager.model.Item;
import com.example.shop_rent_manager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders od \n" +
            "join order_item oi on od.id = oi.order_id \n" +
            "join items it on it.id = oi.item_id \n" +
            "where it.name LIKE %:keyword%", nativeQuery = true)
    public List<Order> search(@Param("keyword") String keyword);
}
