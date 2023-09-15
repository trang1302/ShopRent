package com.example.shop_rent_manager.controller;

import com.example.shop_rent_manager.model.Item;
import com.example.shop_rent_manager.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/items")
public class ItemController {

    private ItemService itemService;

    // Build create Item REST API
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            Item savedItem = itemService.createItem(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            // Xử lý lỗi thêm mặt hàng không thành công
            // Thông báo lỗi hoặc thực hiện các thao tác phù hợp
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Build get item by id REST API
    // http://localhost:8080/api/items/1
    @GetMapping("{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long itemId) {
        Item item = itemService.getItemById(itemId);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Build Get All Items REST API
    // http://localhost:8080/api/items
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Build Update Item REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/items/1
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long itemId, @RequestBody Item item) {
        item.setId(itemId);
        Item updatedItem = itemService.updateItem(item);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Build Delete Item REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>("Item successfully deleted!", HttpStatus.OK);
    }

    // Build search items by content REST API
    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItemsByContent(@RequestParam("content") String content) {
        List<Item> items = itemService.searchItemsByContent(content);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}