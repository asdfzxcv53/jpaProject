package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class ItemRequestDto {
    Long id;
    int quantity;

    // 사려는 item 의 기본키 와 수량.
}
