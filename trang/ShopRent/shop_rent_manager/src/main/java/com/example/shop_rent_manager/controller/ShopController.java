package com.example.shop_rent_manager.controller;

import com.example.shop_rent_manager.model.Shop;
import com.example.shop_rent_manager.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/shops")
public class ShopController {

    private ShopService shopService;

    // Build create Shop REST API
    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        try {
            Shop savedShop = shopService.createShop(shop);
            return new ResponseEntity<>(savedShop, HttpStatus.CREATED);
        } catch (Exception e) {
            // Xử lý lỗi thêm cửa hàng không thành công
            // Thông báo lỗi hoặc thực hiện các thao tác phù hợp
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Build get shop by id REST API
    // http://localhost:8080/api/shops/1
    @GetMapping("{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable("id") Long shopId) {
        Shop shop = shopService.getShopById(shopId);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    // Build Get All Shops REST API
    // http://localhost:8080/api/shops
    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    // Build Update Shop REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/shops/1
    public ResponseEntity<Shop> updateShop(@PathVariable("id") Long shopId,
                                           @RequestBody Shop shop) {
        shop.setId(shopId);
        Shop updatedShop = shopService.updateShop(shop);
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

    // Build Delete Shop REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShop(@PathVariable("id") Long shopId) {
        shopService.deleteShop(shopId);
        return new ResponseEntity<>("Shop successfully deleted!", HttpStatus.OK);
    }
}