package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Order;
import com.example.shop_rent_manager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;
  public List<Order> listAll(String keyword) {
      if(keyword != null){
          return orderRepository.search(keyword);
      } return null;
  }

}