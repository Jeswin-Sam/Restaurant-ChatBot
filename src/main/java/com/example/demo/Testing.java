package com.example.demo;

import com.example.demo.service.DialogFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.IntentExtractor.*;

public class Testing {

    public static void main(String[] args) {

        String jsonInput = "{\n" +
                "  \"responseId\": \"9ab256ee-2cf3-4e50-a076-b404e0cc5e8c-0fffcc35\",\n" +
                "  \"queryResult\": {\n" +
                "    \"queryText\": \"three\",\n" +
                "    \"parameters\": {\n" +
                "      \"number\": [\n" +
                "        3\n" +
                "      ]\n" +
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
                "          \"number\": [\n" +
                "            3\n" +
                "          ],\n" +
                "          \"number.original\": [\n" +
                "            \"three\"\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"projects/restaurant-chatbot-wcey/agent/sessions/29da999c-9756-373e-891e-4c7e69bc0eed/contexts/ongoing-order\",\n" +
                "        \"parameters\": {\n" +
                "          \"number\": [\n" +
                "            3\n" +
                "          ],\n" +
                "          \"number.original\": [\n" +
                "            \"three\"\n" +
                "          ],\n" +
                "          \"Food-item\": [\n" +
                "            \"Biryani\"\n" +
                "          ],\n" +
                "          \"Food-item.original\": [\n" +
                "            \"biryani\"\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"projects/restaurant-chatbot-wcey/agent/sessions/29da999c-9756-373e-891e-4c7e69bc0eed/contexts/__system_counters__\",\n" +
                "        \"parameters\": {\n" +
                "          \"no-input\": 0,\n" +
                "          \"no-match\": 0,\n" +
                "          \"number\": [\n" +
                "            3\n" +
                "          ],\n" +
                "          \"number.original\": [\n" +
                "            \"three\"\n" +
                "          ]\n" +
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
