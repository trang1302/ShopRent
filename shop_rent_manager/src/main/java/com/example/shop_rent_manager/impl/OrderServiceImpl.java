package com.example.shop_rent_manager.impl;

import com.example.shop_rent_manager.model.Order;
import com.example.shop_rent_manager.repository.OrderRepository;
import com.example.shop_rent_manager.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.get();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId()).get();
        existingOrder.setDate(order.getDate());
        Order updatedOrder = orderRepository.save(existingOrder);
        return updatedOrder;
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}