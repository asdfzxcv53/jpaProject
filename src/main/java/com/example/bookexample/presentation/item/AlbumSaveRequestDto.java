package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class AlbumSaveRequestDto extends ItemSaveRequestDto {
    String artist;
    String etc;
}
