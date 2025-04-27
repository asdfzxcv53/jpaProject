package com.example.bookexample.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

    @Embedded
    private Address address;

    public Member() {}

    @Builder
    public Member(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
