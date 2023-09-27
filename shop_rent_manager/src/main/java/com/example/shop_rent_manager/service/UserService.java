package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.User;
import com.example.shop_rent_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  public List<User> listAllUser(String keyword) {
      if(keyword != null){
          return userRepository.searchUserByShop(keyword);
      } return null;
  }
}