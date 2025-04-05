package com.example.chat_server.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private String name;
    private int quantity;

    public ItemDTO(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}