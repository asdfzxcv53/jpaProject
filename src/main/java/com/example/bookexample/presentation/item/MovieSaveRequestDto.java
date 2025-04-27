package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class MovieSaveRequestDto extends ItemSaveRequestDto {
    String director;
    String actor;
}
