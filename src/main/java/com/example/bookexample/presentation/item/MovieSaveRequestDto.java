package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class MovieSaveRequestDto extends ItemSaveRequestDto {
    String director;
    String actor;

    public MovieSaveRequestDto() {}
    public MovieSaveRequestDto(String name, int price, int stockQuantity, String director, String actor) {
        super(name, price, stockQuantity);
        this.director = director;
        this.actor = actor;
    }
}
