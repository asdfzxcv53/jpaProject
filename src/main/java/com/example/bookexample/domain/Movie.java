package com.example.bookexample.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;


@Getter
@Entity
@DiscriminatorValue("M")
public class Movie extends Item {

    private String director;
    private String actor;

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    protected Movie() {}

    @Builder
    public Movie(Long id, String name, int price, int stockQuantity, String director, String actor) {
        super(id, name, price, stockQuantity);
        this.director = director;
        this.actor = actor;
    }
}
