package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.PlannermainpageCard;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.RequirementRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpringDataJpaRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class PlannerMainPageService {
    private final PlannerRepository plannerRepository;
    private  final SpringDataJpaRequirementRepository requirementRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public PlannerMainPageService(PlannerRepository plannerRepository, SpringDataJpaRequirementRepository requirementRepository, MemberRepository memberRepository) {
        this.plannerRepository = plannerRepository;
        this.requirementRepository = requirementRepository;
        this.memberRepository = memberRepository;
    }

    public List<PlannermainpageCard> card = new ArrayList<>();

    public List<PlannermainpageCard> returnPlannerMainCard(int plannerNo) throws IOException {
        card = new ArrayList<>();

        Planner planner = plannerRepository.findByplannerNo(plannerNo).get();
        String region = planner.getRegion();
        List<Requirement> requirementList = requirementRepository.findByQ1CityOrderByQ1DateAsc(region);
        //System.out.println(requirementList);
        for (Requirement requirement : requirementList) {
            PlannermainpageCard eachCard = new PlannermainpageCard();
            eachCard.setEstimate(requirement.getQ7Estimate());
            eachCard.setCity(requirement.getQ1City());
            eachCard.setGu(requirement.getQ1Gu());
            Member member = memberRepository.findByRequirementPk((int)requirement.getRequirementNo());
            eachCard.setMemberPk(member.getMemberNo());
            eachCard.setMemberName(member.getName());
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
            card.add(eachCard);
        }
        return card;
    }
}
