package com.example.demo.service;

import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.OrderBillRepository;
import com.example.demo.repository.OrderItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private final OrderBillRepository orderBillRepository;

    public OrderItemService(OrderBillRepository orderBillRepository, MenuItemRepository menuItemRepository, OrderItemRepository orderItemRepository) {
        this.orderBillRepository = orderBillRepository;
    }


}
