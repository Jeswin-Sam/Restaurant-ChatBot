package com.example.demo.controller;

import com.example.demo.entity.MenuItem;
import com.example.demo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;

    // get all menu items
    @GetMapping("/menu/items")
    public ResponseEntity<List<MenuItem>> getItems(){
        List<MenuItem> items = menuItemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // add new menu item
    @PostMapping("/menu/add")
    public ResponseEntity<MenuItem> addItem(@RequestBody MenuItem menuItem){
        menuItemService.addMenuItem(menuItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // remove menu item
    @DeleteMapping("/menu/delete")
    public ResponseEntity<MenuItem> deleteMenuItem(@RequestBody MenuItem menuItem){
        menuItemService.deleteMenuItem(menuItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // update menu item
    @PutMapping("/menu/update")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem menuItem){
        menuItemService.updateMenuItem(menuItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
