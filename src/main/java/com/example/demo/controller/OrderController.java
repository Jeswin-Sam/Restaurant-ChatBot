package com.example.demo.controller;

import com.example.demo.entity.OrderBill;
import com.example.demo.service.MenuItemService;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderItemService orderItemService;
    OrderService orderService;
    MenuItemService menuItemService;

//    // get order by id
//    @GetMapping("/orders/{id}")
//    @ResponseBody
//    public ResponseEntity<OrderBill> getOrderById(@PathVariable Long id){
//        OrderBill order = orderService.getOrderById(id);
//        if (order==null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        else
//            return new ResponseEntity<>(order,HttpStatus.OK);
//    }

}
