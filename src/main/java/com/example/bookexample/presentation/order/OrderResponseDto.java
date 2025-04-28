package com.example.bookexample.presentation.order;

import com.example.bookexample.presentation.OrderItemResponseDto;

import java.util.Date;
import java.util.List;

public class OrderResponseDto {
    Long orderId;
    Date orderDate;
    List<OrderItemResponseDto> orderItemResponseDtos;

    public OrderResponseDto() {}
    public OrderResponseDto(Long orderId, Date orderDate, List<OrderItemResponseDto> orderItemResponseDtos) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderItemResponseDtos = orderItemResponseDtos;
    }
}
