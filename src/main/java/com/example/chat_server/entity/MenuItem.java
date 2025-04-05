package com.example.chat_server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;
    private int price;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference(value = "menu-order")
    private List<OrderItem> orderItems;


}