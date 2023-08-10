package kr.com.greenart.sdmate.pjsdmate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.com.greenart.sdmate.pjsdmate.domain.MemberRequirement;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRequirementRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.RequirementRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpringDataJpaRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequirementService {

    private final SpringDataJpaRequirementRepository requirementRepository;
    private final ObjectMapper objectMapper;

    private final MemberRequirementRepository memberRequirementRepository;




    @Autowired
    public RequirementService(SpringDataJpaRequirementRepository requirementRepository, ObjectMapper objectMapper, MemberRequirementRepository memberRequirementRepository) {
        this.requirementRepository = requirementRepository;
        this.objectMapper = objectMapper;
        this.memberRequirementRepository = memberRequirementRepository;
    }


//    public Requirement getRequirementByNo(int requirementNo) {
//        Requirement requirement = requirementRepository.findByrequirementNo(requirementNo).get();
//        return requirement;
//    }

    public Integer insertRequirement(Requirement requirement,Integer memberPk) {

        if(requirement != null){
//            Requirement requirement = optionalRequirementrequirement.get();
            requirementRepository.save(requirement);

            MemberRequirement memberRequirement = new MemberRequirement();

            memberRequirement.setMemberNo(memberPk);
            memberRequirement.setRequiremnetNo(requirement.getRequirement_no());

            memberRequirementRepository.save(memberRequirement);
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
}
