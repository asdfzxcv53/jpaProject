package com.example.bookexample.presentation.order;

import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long itemId;
    private int orderQuantity;
}
