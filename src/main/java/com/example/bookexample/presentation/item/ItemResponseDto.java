package com.example.bookexample.presentation.item;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AlbumResponseDto.class, name = "album"),
        @JsonSubTypes.Type(value = BookResponseDto.class, name = "book"),
        @JsonSubTypes.Type(value = MovieResponseDto.class, name = "movie")
})
public abstract class ItemResponseDto {
    Long id;
    String name;
    int price;
    int stockQuantity;

    public ItemResponseDto() {}
    public ItemResponseDto(Long id, String name, int price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
