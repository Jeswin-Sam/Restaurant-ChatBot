package com.example.chat_server;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class IntentExtractor {

    public static Long getOrderId(String jsonInput) {
        // Parse the JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonInput);
            // Extract the "number"
            return rootNode.path("queryResult").path("parameters").path("number").asLong();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String getIntent(String jsonInput) {
        // Parse the JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonInput);

            // Extract the intent display name
            String intentDisplayName = rootNode.path("queryResult").path("intent").path("displayName").asText();

            return intentDisplayName;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    public static List<Integer> getNumbers(String jsonInput) {
        // Parse the JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonInput);

            // Extract the "number" array
            List<Integer> numbers = new ArrayList<>();
            JsonNode numberNodes = rootNode.path("queryResult").path("parameters").path("number");

            for (JsonNode numberNode : numberNodes)
                numbers.add(numberNode.asInt());

            return numbers;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<String> getFoodItemsList(String jsonInput) {
        // Parse the JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonInput);

            // Extract the "Food-item" array
            List<String> foodItems = new ArrayList<>();
            JsonNode foodItemNodes = rootNode.path("queryResult").path("parameters").path("Food-item");

            for (JsonNode foodItemNode : foodItemNodes)
                foodItems.add(foodItemNode.asText());

            return foodItems;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static String getFoodItem(String jsonInput) {
        // Parse the JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonInput);
            // Extract the "number"
            return rootNode.path("queryResult").path("parameters").path("Food-item").asText();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
