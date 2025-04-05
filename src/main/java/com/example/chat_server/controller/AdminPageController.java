package com.example.chat_server.controller;

import com.example.chat_server.entity.MenuItem;
import com.example.chat_server.entity.OrderBill;
import com.example.chat_server.entity.OrderResponseDTO;
import com.example.chat_server.repository.OrderBillRepository;
import com.example.chat_server.service.AdminPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Controller
public class AdminPageController {

    @Autowired
    AdminPageService adminPageService;
    @Autowired
    OrderBillRepository orderBillRepository;

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

    // get order status
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDTO>> getOrderStatus(@RequestParam String status) {
        return new ResponseEntity<>(adminPageService.getOrdersByStatus(status), HttpStatus.OK);
    }

    // get order by id
    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderBill> getBillById(@PathVariable Long id) {
        return new ResponseEntity<>(adminPageService.getOrderById(id), HttpStatus.OK);
    }

    // Update order status
    @PutMapping("/orders/updateStatus/{orderId}")
    public ResponseEntity<String> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {
        Optional<OrderBill> orderOptional = orderBillRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            OrderBill order = orderOptional.get();
            order.setStatus(status);
            orderBillRepository.save(order);
            return ResponseEntity.ok("Order status updated to " + status);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
    }
}
