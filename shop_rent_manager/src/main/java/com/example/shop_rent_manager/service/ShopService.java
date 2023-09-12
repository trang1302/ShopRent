package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Shop;

import java.util.List;

public interface ShopService {
    Shop createShop(Shop shop);

    Shop getShopById(Long shopId);

    List<Shop> getAllShops();

    Shop updateShop(Shop shop);

    void deleteShop(Long shopId);
}