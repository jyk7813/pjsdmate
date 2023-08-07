package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceTest {
   @Autowired
   MemberService memberService;
    @Autowired MemberRepository memberRepository;

//    @Test
//    void searchByid() {
//        Member member = memberService.get
//    }

    @Test
    void 찿기(){

        Member member = memberService.getMemberByPK(1);
        System.out.print(member.getName());
    }
}