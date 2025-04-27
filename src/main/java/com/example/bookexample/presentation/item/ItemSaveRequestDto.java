package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class ItemSaveRequestDto {
    String name;
    int price;
    int stockQuantity;
}
