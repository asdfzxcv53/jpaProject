package com.example.bookexample.controllertest;

import com.example.bookexample.application.MemberService;
import com.example.bookexample.domain.Address;
import com.example.bookexample.presentation.controller.MemberController;
import com.example.bookexample.presentation.member.MemberRequestDto;
import com.example.bookexample.presentation.member.MemberResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("회원 가입 API 테스트")
    public void createMember() throws Exception {
        MemberRequestDto memberRequestDto = new MemberRequestDto();
        memberRequestDto.setName("송승우");
        memberRequestDto.setAddress(new Address("서울"));

        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setId(1L);
        memberResponseDto.setName("송승우");

        Mockito.when(memberService.join(Mockito.any(MemberRequestDto.class)))
                .thenReturn(memberResponseDto);

        mockMvc.perform(post("/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(memberRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("송승우"));
    }

}
