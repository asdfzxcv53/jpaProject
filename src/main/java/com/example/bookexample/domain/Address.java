package com.example.bookexample.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    String street;

    public Address(String street) {
        this.street = street;
    }
    public Address(){}
}
