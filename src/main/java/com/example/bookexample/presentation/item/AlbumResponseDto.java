package com.example.bookexample.presentation.item;

import com.example.bookexample.domain.Album;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("album")
public class AlbumResponseDto extends ItemResponseDto {
    String artist;
    String etc;

    public AlbumResponseDto() {}
    public AlbumResponseDto(Long id, String name, int price, int stockQuantity, String artist, String etc) {
        super(id, name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
