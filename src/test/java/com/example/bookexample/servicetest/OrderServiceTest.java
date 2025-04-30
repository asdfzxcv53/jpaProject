package com.example.bookexample.servicetest;

import com.example.bookexample.application.OrderService;
import com.example.bookexample.domain.*;
import com.example.bookexample.infrastructure.ItemRepository;
import com.example.bookexample.infrastructure.MemberRepository;
import com.example.bookexample.infrastructure.OrderRepository;
import com.example.bookexample.presentation.order.OrderRequestDto;
import com.example.bookexample.presentation.order.OrderResponseDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    @DisplayName("주문 저장")
    public void saveOrder() throws Exception {

        // given

        List<OrderRequestDto> orderRequestDtos = new ArrayList<>();
        OrderRequestDto orderRequestDto1 = new OrderRequestDto(1L, 5);
        OrderRequestDto orderRequestDto2 = new OrderRequestDto(2L, 10);
        orderRequestDtos.add(orderRequestDto1);
        orderRequestDtos.add(orderRequestDto2);

        Book book = new Book(1L, "spring", 1000, 40, "seunwoo", "1234");
        Album album = new Album(2L, "moojae", 5000, 10, "bigbang", "etc");

        when(itemRepository.findOne(1L)).thenReturn(book);
        when(itemRepository.findOne(2L)).thenReturn(album);
        when(memberRepository.findOne(any(Long.class))).thenReturn(new Member(1L, "송승우", new Address("seoul")));

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(book, 1000, 5));
        orderItems.add(new OrderItem(album, 5000, 10));
        Order savedOrder = new Order(new Member(), new Delivery(), new Date(), OrderStatus.ORDER);
        savedOrder.setOrderItems(orderItems);

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        // when

        OrderResponseDto orderResponseDto = orderService.createOrder(1L, orderRequestDtos);


        // then

        assertThat(orderResponseDto.getOrderItemResponseDtos())
                .hasSize(2)
                .extracting("itemId")
                .containsExactly(1L, 2L);
    }
}
