package com.example.demo.controller;

import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.service.DialogFlowService;
import com.example.demo.service.MenuItemService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.json.simple.JSONObject;
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
    public JSONObject processRequest(@RequestBody String jsonInput){

        String intent = getIntent(jsonInput);
        Long orderId = getOrderId(jsonInput);

        List<String> foodItems = getFoodItems(jsonInput);
        List<Integer> numbers = getNumbers(jsonInput);

        JSONObject jsonObject = new JSONObject();

        switch (intent) {

            case "New Order Intent": {
                dialogFlowService.newOrder();
                return jsonObject;
            }
            case "Add to order Intent": {
                jsonObject.put("fulfillmentText", dialogFlowService.addToOrder(foodItems, numbers));
                return jsonObject;
            }
            case "Remove from order Intent": {
                jsonObject.put("fulfillmentText", dialogFlowService.removeFromOrder(foodItems,numbers));
                return jsonObject;
            }
            case "Order Complete Intent":{
                jsonObject.put("fulfillmentText", dialogFlowService.finishOrder());
                return jsonObject;
            }
            case "Track order with order number": {
                jsonObject.put("fulfillmentText", dialogFlowService.getOrderStatusById(orderId));
                return jsonObject;
            }
        }
        return jsonObject;
    }
}
