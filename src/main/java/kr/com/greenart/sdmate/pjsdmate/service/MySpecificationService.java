package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.*;
import kr.com.greenart.sdmate.pjsdmate.repository.*;
import org.springframework.stereotype.Service;

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

    private final PlannerRepository plannerRepository;

    public MySpecificationService(PlannerSpecificationPackageRepository plannerSpecificationPackageRepository, SpecificationRepository specificationRepository, MemberRepository memberRepository, RequirementRepository requirementRepository, PlannerRepository plannerRepository) {
        this.plannerSpecificationPackageRepository = plannerSpecificationPackageRepository;
        this.specificationRepository = specificationRepository;
        this.memberRepository = memberRepository;

        this.requirementRepository = requirementRepository;
        this.plannerRepository = plannerRepository;
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
    public int returnPlannerNoBySpeNo(int specificationNo) {
        PlannerSpecificationPackage plannerSpecificationPackage = plannerSpecificationPackageRepository.findBySpecificationNo(specificationNo);
        return plannerSpecificationPackage.getPlannerNo();
    }

    public String returnString(int value) {
        String string=null;
        if (value == 500) {
            string = "~500만원 이하";
        }
        if (value == 1000) {
            string = "500만원 ~ 1000만원";
        }
        if (value == 1500) {
            string = "1000만원 ~ 1500만원";
        }
        if (value == 2000) {
            string = "1500만원 ~ 2000만원";
        }
        if (value == 9999) {
            string = "상관없음 (프리미엄)";
        }
        return string;
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
            eachCard.setRequirementPrice(returnString(requirement.getQ7Estimate()));
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
}
