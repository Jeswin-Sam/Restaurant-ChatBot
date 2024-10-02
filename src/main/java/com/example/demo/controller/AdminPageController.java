package com.example.demo.controller;

import com.example.demo.entity.MenuItem;
import com.example.demo.entity.OrderBill;
import com.example.demo.entity.OrderResponseDTO;
import com.example.demo.service.AdminPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
public class AdminPageController {

    @Autowired
    AdminPageService adminPageService;

    // get all menu items
    @GetMapping("/menu/items")
    public ResponseEntity<List<MenuItem>> getItems(){
        List<MenuItem> items = adminPageService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // add new menu item
    @PostMapping("/menu/add")
    public ResponseEntity<MenuItem> addItem(@RequestBody MenuItem menuItem){
        adminPageService.addMenuItem(menuItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // remove menu item
    @DeleteMapping("/menu/delete/{id}")
    public ResponseEntity<MenuItem> deleteMenuItemById(@PathVariable Long id){
        adminPageService.deleteMenuItemById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // update menu item
    @PutMapping("/menu/update")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem menuItem){
        adminPageService.updateMenuItem(menuItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // get pending orders
    @GetMapping("/orders/pending")
    public ResponseEntity<List<OrderResponseDTO>> getPendingOrders(){
        return new ResponseEntity<>(adminPageService.getOrdersByStatus("Pending"), HttpStatus.OK);
    }

    // get completed orders
    @GetMapping("/orders/completed")
    public ResponseEntity<List<OrderResponseDTO>> getCompletedOrders(){
        return new ResponseEntity<>(adminPageService.getOrdersByStatus("Completed"), HttpStatus.OK);
    }

    // get order by id
    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderBill> getBillById(@PathVariable Long id) {
        return new ResponseEntity<>(adminPageService.getOrderById(id), HttpStatus.OK);
    }

}
