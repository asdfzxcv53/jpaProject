package com.example.bookexample.presentation.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto extends ItemResponseDto {
    String author;
    String isbn;
}
