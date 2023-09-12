package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);
}