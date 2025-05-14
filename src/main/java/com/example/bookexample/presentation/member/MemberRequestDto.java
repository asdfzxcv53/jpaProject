package com.example.bookexample.presentation.member;

import com.example.bookexample.domain.Address;
import com.example.bookexample.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {
    private String name;
    private String username;
    private String password;
    private Address address;

    public Member toEntity() {
        Member member = Member
                .builder()
                .name(name)
                .username(username)
                .password(password)
                .address(address)
                .build();

        return member;
    }

    public MemberRequestDto() {}

    public MemberRequestDto(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
