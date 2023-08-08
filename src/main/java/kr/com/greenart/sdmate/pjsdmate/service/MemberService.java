package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    private final ValidatorMember validatorMember;



    @Autowired
    public MemberService(MemberRepository memberRepository, ValidatorMember validatorMember, ValidatorMember validatorMember1) {
        this.memberRepository = memberRepository;
        this.validatorMember = validatorMember1;
    }
    public Member getMemberByPK(int member_no){
        Member member = memberRepository.findBymemberNo(member_no).get();

        return member;
    }
    //id 를 받아서 멤버 테이블에서 조회하고 적합성 검사를 한뒤에
    public Integer Login(String id,String pass){


        // 레포지토리에서 값 뺴오기
        Optional<Member> optionalMember = memberRepository.findById(id);
        Member member = null;
        // 값이 존재하고 비밀번호가 같다면 멤버를 반환 없으면 통과해서 null 을 반환
        //
        if(optionalMember.isPresent()){
            Member checkMember = optionalMember.get();
            if(checkMember.getPwd().equals(pass)){
                member = checkMember;
                return member.getMemberNo();
            }
        }
        return null;
    }

    public List<String> validate(String id, String pass){
           Map<String,String> map = validatorMember.validate(id,pass);
           List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            list.add(entry.getValue());
        }
            return list;
    }

    public void join(Member member){

        memberRepository.save(member);
    }


    // member 객체 JSon 파싱용 혹시 필요할까봐 남겨 놨습니다.
//    private Member parseObj(String json) throws JsonProcessingException {
//        Member member = objectMapper.readValue(json, Member.class);
//        return member;
//    }
}
