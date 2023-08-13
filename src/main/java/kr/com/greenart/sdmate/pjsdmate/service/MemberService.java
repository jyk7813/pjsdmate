package kr.com.greenart.sdmate.pjsdmate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.exception.JoinEmailException;
import kr.com.greenart.sdmate.pjsdmate.exception.JoinIdException;
import kr.com.greenart.sdmate.pjsdmate.exception.JoinPhoneNumException;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    private final ValidatorMember validatorMember;

    private final ObjectMapper objectMapper;



    @Autowired
    public MemberService(MemberRepository memberRepository, ValidatorMember validatorMember, ObjectMapper objectMapper) {
        this.memberRepository = memberRepository;
        this.validatorMember = validatorMember;
        this.objectMapper = objectMapper;
    }
    public Member getMemberByPK(int member_no){
        Member member = memberRepository.findBymemberNo(member_no).get();

        return member;
    }


    //id 를 받아서 멤버 테이블에서 조회하고 적합성 검사를 한뒤에
    public Member Login(String id,String pass){
        // 레포지토리에서 값 뺴오기
        Optional<Member> optionalMember = memberRepository.findById(id);
        Member member = null;
        // 값이 존재하고 비밀번호가 같다면 멤버를 반환 없으면 통과해서 null 을 반환
        //
        if(optionalMember.isPresent()){
            Member checkMember = optionalMember.get();
            if(checkMember.getPwd().equals(pass)){
                member = checkMember;
                return member;
            }
        }
        return null;
    }
//    public void join(String json){
//        Member member =parseObj(json);
//
//        member.setActive(true);
//
//        memberRepository.save(member);
//        // 아이디 중복 검사
//    }
public void join(Member member){

    member.setActive(true);
    memberRepository.save(member);
}


    public String searchId(String name,String birth){
        String str = null;
        Optional<Member> optionalmember = memberRepository.findByNameAndIdentity_no(name, birth);
        if(optionalmember.isPresent()){
            Member member = optionalmember.get();
            str = member.getId();
            return "찾으시는 아이디는 "+str+" 입니다.";
        }
        str = "해당 아이디는 존재하지 않습니다";
        return str;
    }

    public String searchPassWord(String name,String birth,String id){
        String str = null;
        Optional<Member> optionalMember = memberRepository.findByIdAndIdentity_noAndName(name, birth, id);
        if(optionalMember.isPresent()){
            Member member = optionalMember.get();
            String pass = member.getPwd();

            int halfLength = pass.length()/2;



            StringBuilder result = new StringBuilder();
            for(int i = 0; i<pass.length();i++){
                if(i>=halfLength && i< pass.length()){
                    result.append("*");
                }else{
                    result.append(pass.charAt(i));
                }
            }
            return "찾으시는 비밀번호는 "+result.toString()+ " 입니다";

        }
        return "해당 하는 비밀번호는 존재하지 않습니다";
    }

    // 적합성 검사 하고 에러 문구들을 List 형태로 반환.
    // 에러 문구를 컨트롤러에 반환 해야 하기 때문에 사용을 memberController 에서 합니다.
    public List<String> validate(String id, String pass){
           Map<String,String> map = validatorMember.validateLogin(id,pass);
           List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        validatorMember.cleanMap();
            return list;
    }
    public boolean isIdDuplicated(String id){
        Optional<Member> optionalMember = memberRepository.findById(id);
        if(optionalMember.isPresent()){
            return true;
        }
        return false;
    }


    public List<String> validate(String json){
        Member member = parseObj(json);
        Integer Id_Count = memberRepository.countById(member.getId());

        Integer Email_Count = memberRepository.countByEmail(member.getEmail());

        Map<String,String> map = validatorMember.validateJoin(member,Id_Count,Email_Count);
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        validatorMember.cleanMap();
        return list;
    }

    // member 객체 JSon 파싱용 혹시 필요할까봐 남겨 놨습니다.
    private Member parseObj(String json){
        Member member = null;
        try {
            member = objectMapper.readValue(json, Member.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return member;
    }

    public boolean isEmailDuplicated(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isPhoneNumDuplicated(String phonenum) {
        Optional<Member> optionalMember = memberRepository.findByPhonenum(phonenum);
        if(optionalMember.isPresent()){
            return true;
        }
        return false;
    }
}
