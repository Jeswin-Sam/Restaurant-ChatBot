package com.example.chat_server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "orderBill", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> items;

    private String status;
    private Date orderDate;
    private int totalAmount;

}

