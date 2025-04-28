package com.example.bookexample.presentation.member;

import com.example.bookexample.domain.Address;
import com.example.bookexample.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {
    private Long id;
    private String name;
    private Address address;

    public static MemberResponseDto fromEntity(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.id = member.getId();
        memberResponseDto.name = member.getName();
        memberResponseDto.address = member.getAddress();

        return memberResponseDto;
    }
}
