package com.example.bookexample.presentation.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponseDto extends ItemResponseDto {
    String director;
    String actor;
}
