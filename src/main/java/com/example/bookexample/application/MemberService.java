package com.example.bookexample.application;

import com.example.bookexample.domain.Member;
import com.example.bookexample.infrastructure.MemberRepository;
import com.example.bookexample.presentation.member.MemberRequestDto;
import com.example.bookexample.presentation.member.MemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public MemberResponseDto join(MemberRequestDto memberRequestDto) {
        // 회원 중복 확인
        validateDuplicateMember(memberRequestDto);

        Member member = memberRequestDto.toEntity();
        Member savedMember = memberRepository.save(member);

        MemberResponseDto memberResponseDto = MemberResponseDto.fromEntity(savedMember);

        return memberResponseDto;
    }

    private void validateDuplicateMember(MemberRequestDto memberRequestDto) {
        List<Member> findMembers = memberRepository.findByName(memberRequestDto.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //전체회원 조회
    public List<MemberResponseDto> findMembers() {
        List<Member> findMembers = memberRepository.findAll();
        return findMembers
                .stream()
                .map(member -> MemberResponseDto.fromEntity(member))
                .toList();
    }
}
