package com.example.bookexample.presentation.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto extends ItemResponseDto {
    String author;
    String isbn;

    public BookResponseDto() {}
    public BookResponseDto(Long id, String name, int price, int stockQuantity, String author, String isbn) {
        super(id, name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
