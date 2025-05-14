package com.example.bookexample.presentation.member;

import com.example.bookexample.domain.Address;
import com.example.bookexample.domain.Member;
import com.example.bookexample.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {
    private Long id;
    private String name;
    private String username;
    private Role role;
    private Address address;

    public static MemberResponseDto fromEntity(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.id = member.getId();
        memberResponseDto.name = member.getName();
        memberResponseDto.username = member.getUsername();
        memberResponseDto.role = member.getRole();
        memberResponseDto.address = member.getAddress();

        return memberResponseDto;
    }
}
