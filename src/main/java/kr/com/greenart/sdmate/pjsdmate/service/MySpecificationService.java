package kr.com.greenart.sdmate.pjsdmate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.com.greenart.sdmate.pjsdmate.domain.*;
import kr.com.greenart.sdmate.pjsdmate.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class MySpecificationService {
    private final PlannerSpecificationPackageRepository plannerSpecificationPackageRepository;
    private final SpecificationRepository specificationRepository;
    private final MemberRepository memberRepository;
    private final RequirementRepository requirementRepository;

    public MySpecificationService(PlannerSpecificationPackageRepository plannerSpecificationPackageRepository, SpecificationRepository specificationRepository, MemberRepository memberRepository, RequirementRepository requirementRepository) {
        this.plannerSpecificationPackageRepository = plannerSpecificationPackageRepository;
        this.specificationRepository = specificationRepository;
        this.memberRepository = memberRepository;

        this.requirementRepository = requirementRepository;
    }

    public List<MySpecification> cardList = new ArrayList<>();

    public Member returnMember(int requirementNo) {
        Member member = memberRepository.findByRequirementPk(requirementNo);
        return member;
    }
    public Requirement returnRequirement(int requirementNo) {
        Requirement requirement = requirementRepository.findByRequirementNo(requirementNo).get();
        return requirement;
    }
    public Specification returnSpecification(int specificationNo) {
        Specification specification = specificationRepository.findBySpecificationNo(specificationNo).get();
        return specification;
    }

    public List<MySpecification> returnMySpeList(int plannerNo) throws IOException {
        cardList = new ArrayList<>();

        List<PlannerSpecificationPackage> packageList = plannerSpecificationPackageRepository.findByPlannerNo(plannerNo);
        for (PlannerSpecificationPackage plannerSpecificationPackage : packageList) {
            MySpecification eachCard = new MySpecification();
            int memberNo = plannerSpecificationPackage.getMemberNo();
            System.out.println("멤버넘버" + memberNo); //9
            Member member = memberRepository.findByMemberNo(memberNo).get();
            int requirementNo = member.getRequirementPk();
            Requirement requirement = requirementRepository.findByRequirementNo(requirementNo).get();
            eachCard.setSpecificationNo(plannerSpecificationPackage.getSpecificationNo());
            eachCard.setRequirementPk(requirement.getRequirementNo());
            eachCard.setRequirementPrice(requirement.getQ7Estimate());
            String encoded = null;
            try {
                encoded = Base64.getEncoder().encodeToString(member.getImage());
            } catch (NullPointerException e) {
                String imagePath = "src/main/resources/static/img/profileDefault.png"; // 이미지 파일 경로
                Path path = Paths.get(imagePath);
                byte[] imageBytes = Files.readAllBytes(path);
                encoded = Base64.getEncoder().encodeToString(imageBytes);
            } finally {
                eachCard.setMemberImg(encoded);
            }
            eachCard.setMemberName(member.getName());
            eachCard.setCity(requirement.getQ1City());
            eachCard.setGu(requirement.getQ1Gu());
            int specificationNo = plannerSpecificationPackage.getSpecificationNo();
            eachCard.setSpecificationPrice(specificationRepository.findBySpecificationNo(specificationNo).get().calculateSumExceptSpecNoAndState());

            cardList.add(eachCard);
        }
        return cardList;
    }

    @Service
    public static class RequirementService {

        private final SpringDataJpaRequirementRepository requirementRepository;
        private final ObjectMapper objectMapper;

        private final MemberRequirementRepository memberRequirementRepository;




        @Autowired
        public RequirementService(SpringDataJpaRequirementRepository requirementRepository, ObjectMapper objectMapper, MemberRequirementRepository memberRequirementRepository) {
            this.requirementRepository = requirementRepository;
            this.objectMapper = objectMapper;
            this.memberRequirementRepository = memberRequirementRepository;
        }


        public Requirement getRequirementByNo(int requirementNo) {
            Requirement requirement = requirementRepository.findByRequirementNo(requirementNo).get();
            return requirement;
        }

        public Integer insertRequirement(Requirement requirement,Integer memberPk) {

            if(requirement != null){
    //            Requirement requirement = optionalRequirementrequirement.get();
                requirementRepository.save(requirement);

                MemberRequirement memberRequirement = new MemberRequirement();

                memberRequirement.setMemberNo(memberPk);
                memberRequirement.setRequiremnetNo(requirement.getRequirementNo());

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
        @GetMapping("/userInfo")
        public String userInfo(){

            return "userInfo";
        }
    }
}
