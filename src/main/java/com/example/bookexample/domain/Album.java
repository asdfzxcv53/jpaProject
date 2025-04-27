package com.example.bookexample.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Album(){};

    @Builder
    public Album(Long id, String name, int price, int stockQuantity, String artist, String etc) {
        super(id, name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
