package com.example.bookexample.presentation.controller;

import com.example.bookexample.application.MemberService;
import com.example.bookexample.presentation.member.MemberRequestDto;
import com.example.bookexample.presentation.member.MemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //회원가입
    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto = memberService.join(memberRequestDto);

        return ResponseEntity.ok().body(memberResponseDto);
    }

    // 모든 회원 검색
    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getMember(@PathVariable Long memberId) {
        List<MemberResponseDto> memberResponseDtos = memberService.findMembers();

        return ResponseEntity.ok().body(memberResponseDtos);
    }
}
