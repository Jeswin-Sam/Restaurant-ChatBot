package com.example.chat_server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDTO {
    private Long orderId;
    private List<ItemDTO> items;
    private String status;
    private Date orderDate;
    private double totalAmount;
}



