package com.example.bookexample.presentation.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponseDto extends ItemResponseDto {
    String director;
    String actor;

    public MovieResponseDto() {}
    public MovieResponseDto(Long id, String name, int price, int stockQuantity, String director, String actor) {
        super(id, name, price, stockQuantity);
        this.director = director;
        this.actor = actor;
    }
}
