package com.example.demo.service;

import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    MenuItemRepository menuItemRepository;

    // get all menu items
    public List<MenuItem> getAllItems(){
        return menuItemRepository.findAll();
    }

    // add new menu item
    public void addMenuItem(MenuItem menuItem){
        menuItemRepository.save(menuItem);
    }

    // delete menu item
    public void deleteMenuItem(MenuItem menuItem){
        menuItemRepository.delete(menuItem);
    }

    // update menu item
    public void updateMenuItem(MenuItem menuItem) {
        Optional<MenuItem> existingItemData = menuItemRepository.findById(menuItem.getId());
        if (existingItemData.isPresent()) {
            MenuItem existingItem = existingItemData.get();
            existingItem.setName(menuItem.getName());
            existingItem.setPrice(menuItem.getPrice());
        }
    }

    // find price by name
    public int getPrice(String foodName){
        return menuItemRepository.findByName(foodName).getPrice();
    }

}
