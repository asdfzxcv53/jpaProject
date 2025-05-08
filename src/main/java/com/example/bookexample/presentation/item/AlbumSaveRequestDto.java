package com.example.bookexample.presentation.item;

import lombok.Getter;

@Getter
public class AlbumSaveRequestDto extends ItemSaveRequestDto {
    String artist;
    String etc;

    public AlbumSaveRequestDto() {}
    public AlbumSaveRequestDto(String name, int price, int stockQuantity, String artist, String etc) {
        super(name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
