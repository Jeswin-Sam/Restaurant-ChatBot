package com.example.demo.service;

import com.example.demo.entity.MenuItem;
import com.example.demo.entity.OrderBill;
import com.example.demo.entity.OrderItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.OrderBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DialogFlowService {

    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    OrderBillRepository orderBillRepository;

    static Map<String, Integer> currentOrder = new HashMap<>();

    // track existing order
    public String getOrderStatusById(Long id) {
        Optional<OrderBill> orderData = orderBillRepository.findById(id);
        if (orderData.isEmpty())
            return "Order number " + id + " not found. Please enter the correct order number";
        else
            return "Your order number " + id + " is " + orderData.get().getStatus();
    }

    // to handle new order
    public void newOrder() {
        currentOrder.clear();
    }

    // to display current order
    public String currentOrderText() {
        String outputString = "\nYour current order contains ";

        if (currentOrder.size() == 1) {
            for (String foodItem : currentOrder.keySet()) {
                outputString += currentOrder.get(foodItem) + " " + foodItem + ".";
            }
            outputString += "\nCurrent total is " + currentTotal() + ".";
        } else {
            List<String> foodItems = new ArrayList<>(currentOrder.keySet());
            for (int i = 0; i < foodItems.size() - 1; i++)
                outputString += " " + currentOrder.get(foodItems.get(i)) + " " + foodItems.get(i) + ",";

            outputString += " and " + currentOrder.get(foodItems.getLast()) + " " + foodItems.getLast() + ".";
            outputString += "\nCurrent total is " + currentTotal() + ".";

        }
        return outputString;
    }

    // to get current total
    public int currentTotal() {

        int currentTotal = 0;

        for (String foodItem : currentOrder.keySet()) {
            int itemNumber = currentOrder.get(foodItem);
            int itemPrice = menuItemRepository.findByName(foodItem).getPrice();

            currentTotal += itemPrice * itemNumber;
        }
        return currentTotal;
    }

    // to add items to current order
    public String addToOrder(List<String> foodItems, List<Integer> numbers) {

        if (foodItems.size() != numbers.size())
            return "Please specify the food item and quantity properly.";

        // add to current order
        for (int i = 0; i < foodItems.size(); i++) {
            String foodItem = foodItems.get(i);
            Integer number = numbers.get(i);

            // if food item is already present
            if (currentOrder.containsKey(foodItem)) {
                Integer updatedNumber = currentOrder.get(foodItem) + number;
                currentOrder.put(foodItem, updatedNumber);
            }
            // if food item is not already present
            else
                currentOrder.put(foodItem, number);
        }


        String outputString = "";

        // format the output string
        if (foodItems.size() == 1) {
            outputString += "Added " + numbers.getFirst() + " " + foodItems.getFirst() + ".";
        }

        else {
            outputString += "Added";

            for (int i = 0; i < foodItems.size() - 1; i++) {

                String foodItem = foodItems.get(i);
                Integer number = numbers.get(i);

                outputString += " " + number + " " + foodItem + ",";
            }

            // final item
            outputString += " and " + numbers.getLast() + " " + foodItems.getLast() + ".";
        }

        outputString += currentOrderText();
        outputString += " Do you want to add anything else?";
        return outputString;
    }

    // remove item from order
    public String removeFromOrder(List<String> foodItems, List<Integer> numbers) {

        // if numbers is not empty and number of items is not equal to number of numbers
        if (!numbers.isEmpty() && numbers.size() != foodItems.size())
            return "Please clearly specify the items to be removed.";

        String outputString = "Removed";

        // if number is not specified then remove the item
        if (numbers.isEmpty()) {
            for (String foodItem : foodItems) {
                currentOrder.remove(foodItem);
                outputString += " " + foodItem;
            }
            outputString += currentOrderText();
            outputString += " Do you want to add anything else?";
            return outputString;
        }

        // if number is specified the update the number of that item
        for (int i = 0; i < foodItems.size(); i++) {

            String foodItem = foodItems.get(i);
            Integer minusNumber = numbers.get(i);
            Integer updatedAmount = currentOrder.get(foodItem) - minusNumber;

            currentOrder.put(foodItem, updatedAmount);
            outputString += " " + minusNumber + " " + foodItem;
        }

        outputString += currentOrderText();

        return outputString;
    }

    // insert order into database
    public String finishOrder() {
        OrderBill orderBill = new OrderBill();
        orderBill.setStatus("Pending"); // Set initial status
        orderBill.setOrderDate(new Date());

        // Create order items
        List<OrderItem> orderItems = new ArrayList<>();
        for (String foodItemName : currentOrder.keySet()) {

            int quantity = currentOrder.get(foodItemName);

            // Retrieve MenuItem based on name
            MenuItem menuItem = menuItemRepository.findByName(foodItemName);

            // Create OrderItem
            OrderItem orderItem = new OrderItem(menuItem, quantity, orderBill);
            orderItems.add(orderItem);
        }

        // set total amount and items
        orderBill.setTotalAmount(currentTotal());
        orderBill.setItems(orderItems);

        // save the bill in the database
        OrderBill savedOrderBill = orderBillRepository.save(orderBill);
        Long orderId = savedOrderBill.getId();

        // clear the current order
        currentOrder.clear();
        return "Awesome! Your order is placed. Use the order id " + orderId + " to track your order";
    }

}
