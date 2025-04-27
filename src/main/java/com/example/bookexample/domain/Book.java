package com.example.bookexample.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;



@Getter
@Entity
@DiscriminatorValue("B")
public class Book extends Item {

    private String author;
    private String isbn;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    protected Book(){}

    @Builder
    public Book(Long id, String name, int price, int stockQuantity, String author, String isbn) {
        super(id, name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
