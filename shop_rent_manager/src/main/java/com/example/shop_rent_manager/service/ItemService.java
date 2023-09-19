package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Item;
import com.example.shop_rent_manager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
  @Autowired
  private ItemRepository itemRepository;
  public List<Item> listAll(String keyword) {
      if(keyword != null){
          return itemRepository.search(keyword);
      } return null;
  }

}