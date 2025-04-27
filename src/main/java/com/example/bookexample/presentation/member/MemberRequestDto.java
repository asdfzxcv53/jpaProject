package com.example.bookexample.presentation.member;

import com.example.bookexample.domain.Address;
import com.example.bookexample.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {
    String name;
    Address address;

    public Member toEntity() {
        Member member = Member
                .builder()
                .name(name)
                .address(address)
                .build();

        return member;
    }
}
