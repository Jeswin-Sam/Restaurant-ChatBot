package com.example.demo.controller;

import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.service.DialogFlowService;
import com.example.demo.service.MenuItemService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.IntentExtractor.*;

@RestController
public class DialogFlowController {

    @Autowired
    DialogFlowService dialogFlowService;

    @PostMapping("/dialogflow")
    public void processRequest(@RequestBody String jsonInput){

        String intent = getIntent(jsonInput);
        Long orderId = getOrderId(jsonInput);

        List<String> foodItems = getFoodItems(jsonInput);
        List<Integer> numbers = getNumbers(jsonInput);

        switch (intent) {

            case "New Order Intent": {
                dialogFlowService.newOrder();
                break;
            }
            case "Add to order Intent": {
               dialogFlowService.addToOrder(foodItems, numbers);
                break;
            }
            case "Remove from order Intent": {
                dialogFlowService.removeFromOrder(foodItems,numbers);
                break;
            }
            case "Order Complete Intent":{
                dialogFlowService.finishOrder();
                break;
            }
            case "Track order with order number": {
                dialogFlowService.getOrderStatusById(orderId);
            }
        }
    }
}
