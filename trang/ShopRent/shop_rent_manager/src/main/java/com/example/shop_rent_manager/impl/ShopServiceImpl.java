package com.example.shop_rent_manager.impl;

import com.example.shop_rent_manager.model.Shop;
import com.example.shop_rent_manager.repository.ShopRepository;
import com.example.shop_rent_manager.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

    @Override
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop getShopById(Long shopId) {
        Optional<Shop> optionalShop = shopRepository.findById(shopId);
        return optionalShop.get();
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop updateShop(Shop shop) {
        Shop existingShop = shopRepository.findById(shop.getId()).get();
        existingShop.setName(shop.getName());
        existingShop.setLocation(shop.getLocation());

        Shop updatedShop = shopRepository.save(existingShop);
        return updatedShop;
    }

    @Override
    public void deleteShop(Long shopId) {
        shopRepository.deleteById(shopId);
    }
}