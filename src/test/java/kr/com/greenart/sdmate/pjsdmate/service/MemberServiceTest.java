package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberServiceTest {
   @Autowired
   MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired ValidatorMember validatorMember;


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
    void 로그인_정규식_체크(){
        String id = "test";
        String password = "test1234";
        List<String> validate = memberService.validate(id, password);
        System.out.print(validate);
    }
    @Test
    void 카운트_돌아가는지(){
        Integer i =memberRepository.countById("testJoin");
        Integer x = memberRepository.countByEmail("test@naver.com");
        Assertions.assertEquals(i,1);
        Assertions.assertEquals(x,1);
    }
    @Test
    void 전체정규식_테스트(){
//           테스트를 위해서는 memberService 에서 validate 의
        // json 파라미터를 Member member 로 변경 해줘야한다.
//        Member member=memberRepository.findById("testJoin").get();
//        List<String> list = memberService.validate(member);
//        System.out.println(member);
//        System.out.print(list);
    }

}