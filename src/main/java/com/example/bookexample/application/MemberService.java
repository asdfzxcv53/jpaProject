package com.example.bookexample.application;

import com.example.bookexample.domain.Address;
import com.example.bookexample.domain.Member;
import com.example.bookexample.domain.Role;
import com.example.bookexample.infrastructure.MemberRepository;
import com.example.bookexample.presentation.member.MemberRequestDto;
import com.example.bookexample.presentation.member.MemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //회원가입
    public MemberResponseDto join(MemberRequestDto memberRequestDto) {
        // 회원 중복 확인
        validateDuplicateMember(memberRequestDto);

        Member member = Member.builder()
                .name(memberRequestDto.getName())
                .username(memberRequestDto.getUsername())
                .password(passwordEncoder.encode(memberRequestDto.getPassword()))
                .role(Role.USER)
                .address(memberRequestDto.getAddress())
                .build();

        Member savedMember = memberRepository.save(member);

        MemberResponseDto memberResponseDto = MemberResponseDto.fromEntity(savedMember);

        return memberResponseDto;
    }

    private void validateDuplicateMember(MemberRequestDto memberRequestDto) {
        Optional<Member> findMember = memberRepository.findByUsername(memberRequestDto.getUsername());
        if (findMember.isPresent()) {
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
