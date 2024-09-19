package com.example.demo.controller;

import com.example.demo.service.DialogFlowService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.IntentExtractor.*;

@RestController
public class DialogFlowController {

    @Autowired
    DialogFlowService dialogFlowService;

    @PostMapping("/")
    public JSONObject processRequest(@RequestBody String jsonInput){

        String intent = getIntent(jsonInput);

        List<String> foodItems = getFoodItemsList(jsonInput);
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
                Long orderId = getOrderId(jsonInput);
                jsonObject.put("fulfillmentText", dialogFlowService.getOrderStatusById(orderId));
                return jsonObject;
            }
            case "Item Price Intent": {
                String itemName = getFoodItem(jsonInput);
                jsonObject.put("fulfillmentText", dialogFlowService.getPriceByName(itemName));
            }
        }
        return jsonObject;
    }
}
