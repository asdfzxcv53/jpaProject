package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class BookSaveRequestDto extends ItemSaveRequestDto{
    String author;
    String isbn;

    public BookSaveRequestDto() {}
    public BookSaveRequestDto(String name, int price, int stockQuantity, String author, String isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
