package com.example.bookexample.servicetest;

import com.example.bookexample.application.ItemService;
import com.example.bookexample.application.MemberService;
import com.example.bookexample.domain.Album;
import com.example.bookexample.domain.Item;
import com.example.bookexample.domain.Member;
import com.example.bookexample.infrastructure.ItemRepository;
import com.example.bookexample.infrastructure.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void 회원가입() throws Exception {


    }

    @Test(expected = IllegalStateException.class)
    public void 회원가입_중복_예외() throws Exception {


    }

    @Test
    public void 아이템_저장() throws Exception {


    }
}
