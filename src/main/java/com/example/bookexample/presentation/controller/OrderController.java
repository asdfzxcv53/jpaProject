package com.example.bookexample.presentation.controller;

import com.example.bookexample.application.OrderService;
import com.example.bookexample.presentation.order.OrderRequestDto;
import com.example.bookexample.presentation.order.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //회원 id 와 주문하려는 item 리스트를 이용하여 주문
    @PostMapping("/{memberId}")
    public ResponseEntity<OrderResponseDto> createOrder(@PathVariable Long memberId, @RequestBody List<OrderRequestDto> orderRequestDtos) {
        OrderResponseDto orderResponseDto = orderService.createOrder(memberId, orderRequestDtos);

        return ResponseEntity.ok(orderResponseDto);
    }

    //회원 id 로 그회원의 모든 주문내역 get
    @GetMapping("/{memberId}")
    public ResponseEntity<List<OrderResponseDto>> getOrders(@PathVariable Long memberId) {
        List<OrderResponseDto> orderResponseDtos = orderService.getOrders(memberId);

        return ResponseEntity.ok(orderResponseDtos);
    }

}
