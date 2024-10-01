package com.example.demo.service;

import com.example.demo.entity.MenuItem;
import com.example.demo.entity.OrderBill;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.OrderBillRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminPageService {

    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    OrderBillRepository orderBillRepository;

    // get all menu items
    public List<MenuItem> getAllItems(){
        return menuItemRepository.findAll();
    }

    // add new menu item
    public void addMenuItem(MenuItem menuItem){
        menuItemRepository.save(menuItem);
    }

    // delete menu item
    public void deleteMenuItemById(Long id){
        menuItemRepository.deleteById(id);
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

    // get pending orders
    public List<OrderBill> getPendingOrders() {
        return orderBillRepository.findByStatus("Pending");
    }

    // get completed orders
    public List<OrderBill> getCompletedOrders() {
        return orderBillRepository.findByStatus("Completed");
    }

    // get order by id
    public OrderBill getOrderById(Long id) {
        return orderBillRepository.findById(id).orElse(null);
    }

}
