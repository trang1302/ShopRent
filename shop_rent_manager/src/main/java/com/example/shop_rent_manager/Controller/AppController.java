package com.example.shop_rent_manager.controller;

import com.example.shop_rent_manager.model.Item;
import com.example.shop_rent_manager.service.ItemService;
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
  private ItemService itemService;
  @GetMapping("/")
  public ResponseEntity<List<Item>> getItems(@RequestParam(required = false) String keyword){
      List<Item> itemList = itemService.listAll(keyword);
      return new ResponseEntity<>(itemList, HttpStatus.OK);
  }
}