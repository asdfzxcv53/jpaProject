package com.example.bookexample.presentation.item;

import lombok.Setter;

@Setter
public class BookResponseDto extends ItemResponseDto {
    String author;
    String isbn;
}
