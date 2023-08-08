package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    void 로그인(){
        // 로그인 되면 1 번 pk 유저랑 같음
        //given
        Integer current = memberService.Login("test","test1234");
        Integer missID = memberService.Login("아이디 오타","test1234");
        Integer missPass = memberService.Login("test","비밀번호 오타");
        //then
        Assertions.assertEquals(current,memberService.getMemberByPK(1).getMemberNo());
        Assertions.assertNull(missID);
        Assertions.assertNull(missID);
    }
    @Test
    void 정규식_체크(){
        String id = "test";
        String password = "123 ";
        List<String> validate = memberService.validate(id, password);
        System.out.print(validate);

    }
}