package kr.com.greenart.sdmate.pjsdmate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.domain.SendRequirement;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRequirementRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpringDataJpaRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
public class RequirementService {
    private final SpringDataJpaRequirementRepository requirementRepository;
    private final ObjectMapper objectMapper;

  private final MemberRepository memberRepository;




    @Autowired
    public RequirementService(SpringDataJpaRequirementRepository requirementRepository, ObjectMapper objectMapper, MemberRequirementRepository memberRequirementRepository, MemberRepository memberRepository) {
        this.requirementRepository = requirementRepository;
        this.objectMapper = objectMapper;
        this.memberRepository = memberRepository;
    }


    public Requirement getRequirementByNo(int requirementNo) {
        Requirement requirement = requirementRepository.findByRequirementNo(requirementNo).get();
        return requirement;
    }

    public Integer insertRequirement(Requirement requirement,Integer memberPk) {

        if(requirement != null){
          requirementRepository.save(requirement);

          memberRepository.updateRequirementPk(memberPk,requirement.getRequirementNo());

            return 1;
        }
        return 0;
    }
    private Requirement parseObj(String json){
        Requirement requirement = null;
        try {
            requirement = objectMapper.readValue(json, Requirement.class);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return requirement;
    }

    public SendRequirement setttingRequirement(Requirement requirement){
        SendRequirement sendRequirement = new SendRequirement();
        SendRequirement setting = sendRequirement.setting(sendRequirement, requirement);
        return setting;
    }
    @GetMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }
}

