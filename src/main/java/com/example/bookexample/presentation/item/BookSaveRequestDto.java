package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class BookSaveRequestDto extends ItemSaveRequestDto{
    String author;
    String isbn;
}
