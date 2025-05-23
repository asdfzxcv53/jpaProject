package com.example.bookexample.presentation;

import lombok.Getter;

@Getter
public class OrderItemResponseDto {
    Long itemId;
    String itemName;
    int itemPrice;
    int itemQuantity;

    public OrderItemResponseDto() {}

    public OrderItemResponseDto(Long itemId, String itemName, int itemPrice, int itemQuantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
}
