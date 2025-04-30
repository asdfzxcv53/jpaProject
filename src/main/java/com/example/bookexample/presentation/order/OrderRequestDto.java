package com.example.bookexample.presentation.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private Long itemId;
    private int orderQuantity;

    public OrderRequestDto() {}
    public OrderRequestDto(Long itemId, int orderQuantity) {
        this.itemId = itemId;
        this.orderQuantity = orderQuantity;
    }
}
