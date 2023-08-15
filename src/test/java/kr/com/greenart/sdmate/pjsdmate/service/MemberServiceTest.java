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
import java.util.Optional;
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
    void 회원가입(){
        Member member = new Member();
        member.setName("테스트이름");
        member.setId("id");
        member.setPwd("test이름");
    }
    
    
    @Test
    void 로그인(){
        // 로그인 되면 1 번 pk 유저랑 같음
        //given
        Member current = memberService.Login("gang","gang!");
//        Member missID = memberService.Login("아이디 오타","test1234");
//        Member missPass = memberService.Login("test","비밀번호 오타");
        //then
        Assertions.assertEquals(current.getMemberNo(),memberService.getMemberByPK(12).getMemberNo());
        /*Assertions.assertNull(missID);*/
        /*Assertions.assertNull(missID);*/
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
    @Test
    void 아이디_찾기테스트(){
        Optional<Member> testJoin = memberRepository.findByNameAndIdentity_no("testJoin", "0000000000000");
        Member member =testJoin.get();
        System.out.println(member.getId()+" 요청하신 회원의 id 입니다");

    }
    @Test
    void 비밀번호_찾기(){
        Optional<Member> test = memberRepository.findByIdAndIdentity_noAndName("홍길동", "9309011234567", "test");
        Member member = test.get();
        String s = memberService.searchPassWord("홍길동", "9309011234567", "test");
        System.out.println(s);
    }
}