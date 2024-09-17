package com.example.demo;

import com.example.demo.service.DialogFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.IntentExtractor.*;

public class Testing {

    public static void main(String[] args) {

//        DialogFlowService dialogFlowService = new DialogFlowService();
//
//        List<String> foodItems = List.of("Biryani");
//        List<Integer> numbers = List.of(4);
//
//        System.out.println(dialogFlowService.addToOrder(foodItems,numbers));
//
//        List<String> foodItems2 = List.of("Biryani");
//        List<Integer> numbers2 = List.of(1);
//
//        System.out.println(dialogFlowService.addToOrder(foodItems2,numbers2));
//
//        List<String> foodItems3 = List.of("Biryani");
//        List<Integer> numbers3 = List.of(1);
//
//        System.out.println(dialogFlowService.removeFromOrder(foodItems3,numbers3));
//
//        System.out.println(dialogFlowService.finishOrder());

        String jsonInput = "{\n" +
                "  \"responseId\": \"ddbe3f60-af23-49d5-b58b-83f1f42695ab-0fffcc35\",\n" +
                "  \"queryResult\": {\n" +
                "    \"queryText\": \"45\",\n" +
                "    \"parameters\": {\n" +
                "      \"number\": 45\n" +
                "    },\n" +
                "    \"allRequiredParamsPresent\": true,\n" +
                "    \"fulfillmentMessages\": [\n" +
                "      {\n" +
                "        \"text\": {\n" +
                "          \"text\": [\n" +
                "            \"\"\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"outputContexts\": [\n" +
                "      {\n" +
                "        \"name\": \"projects/restaurant-chatbot-wcey/agent/sessions/29da999c-9756-373e-891e-4c7e69bc0eed/contexts/ongoing-tracking\",\n" +
                "        \"lifespanCount\": 5,\n" +
                "        \"parameters\": {\n" +
                "          \"number\": 45,\n" +
                "          \"number.original\": \"45\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"projects/restaurant-chatbot-wcey/agent/sessions/29da999c-9756-373e-891e-4c7e69bc0eed/contexts/__system_counters__\",\n" +
                "        \"parameters\": {\n" +
                "          \"no-input\": 0,\n" +
                "          \"no-match\": 0,\n" +
                "          \"number\": 45,\n" +
                "          \"number.original\": \"45\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"intent\": {\n" +
                "      \"name\": \"projects/restaurant-chatbot-wcey/agent/intents/499ec79b-7ca0-4062-8a56-e61b02a5ce3b\",\n" +
                "      \"displayName\": \"Track order with order number\"\n" +
                "    },\n" +
                "    \"intentDetectionConfidence\": 1,\n" +
                "    \"languageCode\": \"en\"\n" +
                "  },\n" +
                "  \"originalDetectIntentRequest\": {\n" +
                "    \"source\": \"DIALOGFLOW_CONSOLE\",\n" +
                "    \"payload\": {}\n" +
                "  },\n" +
                "  \"session\": \"projects/restaurant-chatbot-wcey/agent/sessions/29da999c-9756-373e-891e-4c7e69bc0eed\"\n" +
                "}";

        System.out.println(getOrderId(jsonInput));

    }
}
