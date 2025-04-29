package com.example.bookexample.presentation.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("album")
public class AlbumResponseDto extends ItemResponseDto {
    String artist;
    String etc;
}
