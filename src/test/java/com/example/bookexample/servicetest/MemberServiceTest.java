/*
package com.example.bookexample.servicetest;

import com.example.bookexample.application.ItemService;
import com.example.bookexample.application.MemberService;
import com.example.bookexample.domain.Address;
import com.example.bookexample.domain.Album;
import com.example.bookexample.domain.Item;
import com.example.bookexample.domain.Member;
import com.example.bookexample.infrastructure.ItemRepository;
import com.example.bookexample.infrastructure.MemberRepository;
import com.example.bookexample.presentation.member.MemberRequestDto;
import com.example.bookexample.presentation.member.MemberResponseDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    @DisplayName("회원가입 테스트")
    public void join_success() throws Exception {

        //Given

        Address address = new Address();
        address.setStreet("seoul");
        MemberRequestDto memberRequestDto = new MemberRequestDto("송승우", address);
        Member member = new Member(1L, "송승우", address);
        when(memberRepository.findByName("송승우")).thenReturn(List.of());
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        //When

        MemberResponseDto memberResponseDto = memberService.join(memberRequestDto);

        //Then

        assertEquals("송승우", memberResponseDto.getName());
        verify(memberRepository).save(any(Member.class));
    }

    @Test(expected = IllegalStateException.class)
    public void 회원가입_중복_예외() throws Exception {

        //Given

        Address address = new Address();
        address.setStreet("seoul");
        MemberRequestDto memberRequestDto = new MemberRequestDto("송승우", address);
        List<Member> savedMembers = new ArrayList<>();
        savedMembers.add(new Member(1L, "송승우", new Address()));
        when(memberRepository.findByName("송승우")).thenReturn(savedMembers);

        //When

        memberService.join(memberRequestDto);

        //Then
    }
}
*/
