package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);

    Item getItemById(Long itemId);

    List<Item> getAllItems();

    Item updateItem(Item item);

    void deleteItem(Long itemId);
}