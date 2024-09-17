package com.example.demo.service;

import com.example.demo.repository.OrderBillRepository;
import com.example.demo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderService {

    @Autowired
    OrderBillRepository orderBillRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

}
