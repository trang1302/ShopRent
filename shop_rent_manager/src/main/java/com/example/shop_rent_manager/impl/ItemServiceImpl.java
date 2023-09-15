package com.example.shop_rent_manager.impl;

import com.example.shop_rent_manager.model.Item;
import com.example.shop_rent_manager.repository.ItemRepository;
import com.example.shop_rent_manager.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        return optionalItem.get();
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Item item) {
        Item existingItem = itemRepository.findById(item.getId()).get();
        existingItem.setName(item.getName());
        existingItem.setAmount(item.getAmount());
        Item updatedItem = itemRepository.save(existingItem);
        return updatedItem;
    }

    @Override
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}