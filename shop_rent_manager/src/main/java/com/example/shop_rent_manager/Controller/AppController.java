package com.example.shop_rent_manager.Controller;

import com.example.shop_rent_manager.model.Order;
import com.example.shop_rent_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
  @Autowired
  private OrderService orderService;
  @GetMapping("/")
  public ResponseEntity<List<Order>> getOrders(@RequestParam(required = false) String keyword){
      List<Order> orderList = orderService.listAll(keyword);
      return new ResponseEntity<>(orderList, HttpStatus.OK);
  }
}