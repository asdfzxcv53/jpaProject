package com.example.bookexample.application;

import com.example.bookexample.domain.*;
import com.example.bookexample.infrastructure.ItemRepository;
import com.example.bookexample.infrastructure.MemberRepository;
import com.example.bookexample.infrastructure.OrderRepository;
import com.example.bookexample.presentation.OrderItemResponseDto;
import com.example.bookexample.presentation.order.OrderRequestDto;
import com.example.bookexample.presentation.order.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private MemberRepository memberRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, MemberRepository memberRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
    }

    // 주문이 들어오면 주문을 만든다
    public OrderResponseDto createOrder(Long memberId, List<OrderRequestDto> orderRequestDtos) {
        Member member = memberRepository.findOne(memberId);
        Delivery delivery = new Delivery(member.getAddress(), DeliveryStatus.READY);

        Order order = new Order(member, delivery, new Date(), OrderStatus.ORDER);

        for(OrderRequestDto orderRequestDto : orderRequestDtos) {
            Item item = itemRepository.findOne(orderRequestDto.getItemId()); // 주문목록중 순회하면서 itemId 를 이용해 Item 을 찾음
            OrderItem orderItem = new OrderItem(item, item.getPrice(), orderRequestDto.getOrderQuantity());
            order.addOrderItem(orderItem); // 여기서 order 에도 orderItem 을 set 해주고 orderItem 에도 order 을 set 해줌
        }

        orderRepository.save(order); // cascade.ALL 옵션으로 delivery 와 orderItem 들도 모두다 save 된다.

        OrderResponseDto orderResponseDto = new OrderResponseDto(order.getId(), order.getOrderDate(), order.getOrderItems()
                .stream()
                .map(orderItem -> new OrderItemResponseDto(
                        orderItem.getItem().getId(),
                        orderItem.getItem().getName(),
                        orderItem.getOrderPrice(),
                        orderItem.getCount())
                ).toList()
        );

        return orderResponseDto;
    }

    // 회원 id 를 이용한 그회원의 모든 주문기록을 select
    public List<OrderResponseDto> getOrders(Long memberId) {
        List<Order> orders = orderRepository.findOrderWithItemByMemberId(memberId);
        List<OrderResponseDto> orderResponseDtos = orders
                .stream()
                .map(order -> new OrderResponseDto(
                        order.getId(),
                        order.getOrderDate(),
                        order.getOrderItems().stream().map(
                                orderItem -> new OrderItemResponseDto(
                                        orderItem.getItem().getId(),
                                        orderItem.getItem().getName(),
                                        orderItem.getOrderPrice(),
                                        orderItem.getCount()
                                )).toList()
                )).toList();

        return orderResponseDtos;
    }
}
