package com.example.demo;

import com.example.demo.service.DialogFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.IntentExtractor.*;

public class Testing {

    public static void main(String[] args) {

        String jsonInput = "{\n" +
                "  \"responseId\": \"5cbf4dbd-f67a-450d-aab4-fd17cf10e487-0fffcc35\",\n" +
                "  \"queryResult\": {\n" +
                "    \"queryText\": \"what is the price of burger\",\n" +
                "    \"parameters\": {\n" +
                "      \"Food-item\": \"Burger\"\n" +
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
                "        \"name\": \"projects/restaurant-chatbot-wcey/agent/sessions/29da999c-9756-373e-891e-4c7e69bc0eed/contexts/__system_counters__\",\n" +
                "        \"parameters\": {\n" +
                "          \"no-input\": 0,\n" +
                "          \"no-match\": 0,\n" +
                "          \"Food-item\": \"Burger\",\n" +
                "          \"Food-item.original\": \"burger\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"intent\": {\n" +
                "      \"name\": \"projects/restaurant-chatbot-wcey/agent/intents/8bc6f849-1ed8-4320-835e-e9076064eabe\",\n" +
                "      \"displayName\": \"Item Price Intent\"\n" +
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

        System.out.println(getFoodItem(jsonInput));

    }
}
