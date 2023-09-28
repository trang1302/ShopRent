package com.example.shop_rent_manager.Controller;

import com.example.shop_rent_manager.model.Order;
import com.example.shop_rent_manager.model.User;
import com.example.shop_rent_manager.repository.UserRepository;
import com.example.shop_rent_manager.service.OrderService;
import com.example.shop_rent_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//  @GetMapping("/list/{maxAmount}")
//    public ResponseEntity<List<Order>> findOrderMaxAmount(@PathVariable("maxAmount") int maxAmount){
//      List<Order> orderListMax = orderService.OrderMaxAmount(maxAmount);
//      return new ResponseEntity<>(orderListMax, HttpStatus.OK);
//  }

  @GetMapping("/search")
  public ResponseEntity<List<Order>> SearchItem(@RequestParam(required=false) String keyword){
    List<Order> orderssList = orderService.searchItemByName(keyword);
    return new ResponseEntity<>(orderssList, HttpStatus.OK);
  }
  @Autowired
  UserService userService;
  @GetMapping("/searchUserByShop")
  public ResponseEntity<List<User>> SearchUserByShop(@RequestParam(required=false) String keyword){
    List<User> UserList = userService.listAllUser(keyword);
    return new ResponseEntity<>(UserList, HttpStatus.OK);
  }
  @PostMapping ("/add")
  public ResponseEntity<User> addUsers(@RequestBody  User user){
  User newUser = userService.addUser(user);
  return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}