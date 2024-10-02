package com.example.demo;

import com.example.demo.service.DialogFlowService;

public class Testing {

    public static void main(String[] args) {

        DialogFlowService dialogFlowService = new DialogFlowService();

        String jsonInput = "{\n" +
                "  \"responseId\": \"52df9d9e-a58d-4e6f-a289-0af2bb740139-d673503e\",\n" +
                "  \"queryResult\": {\n" +
                "    \"queryText\": \"new order\",\n" +
                "    \"parameters\": {},\n" +
                "    \"allRequiredParamsPresent\": true,\n" +
                "    \"fulfillmentText\": \"asdfg\",\n" +
                "    \"fulfillmentMessages\": [\n" +
                "      {\n" +
                "        \"text\": {\n" +
                "          \"text\": [\n" +
                "            \"asdfg\"\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"outputContexts\": [\n" +
                "      {\n" +
                "        \"name\": \"projects/restaurant-chatbot-wcey/agent/sessions/1a45751c-bf55-88ba-f204-f1183bcf6804/contexts/ongoing-order\",\n" +
                "        \"lifespanCount\": 5\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"projects/restaurant-chatbot-wcey/agent/sessions/1a45751c-bf55-88ba-f204-f1183bcf6804/contexts/__system_counters__\",\n" +
                "        \"parameters\": {\n" +
                "          \"no-input\": 0,\n" +
                "          \"no-match\": 0\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"intent\": {\n" +
                "      \"name\": \"projects/restaurant-chatbot-wcey/agent/intents/12e207b9-7d8e-4c1f-a3e4-f9e68b629790\",\n" +
                "      \"displayName\": \"New Order Intent\"\n" +
                "    },\n" +
                "    \"intentDetectionConfidence\": 1,\n" +
                "    \"languageCode\": \"en\"\n" +
                "  },\n" +
                "  \"originalDetectIntentRequest\": {\n" +
                "    \"source\": \"DIALOGFLOW_CONSOLE\",\n" +
                "    \"payload\": {}\n" +
                "  },\n" +
                "  \"session\": \"projects/restaurant-chatbot-wcey/agent/sessions/1a45751c-bf55-88ba-f204-f1183bcf6804\"\n" +
                "}";

        System.out.println(dialogFlowService.newOrder());

    }
}
