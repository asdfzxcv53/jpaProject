package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class ItemSaveRequestDto {
    String name;
    int price;
    int stockQuantity;

    public ItemSaveRequestDto() {}
    public ItemSaveRequestDto(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
