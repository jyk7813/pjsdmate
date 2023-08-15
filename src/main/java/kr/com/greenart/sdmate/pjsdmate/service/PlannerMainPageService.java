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

        for (Requirement requirement : requirementList) {
            PlannermainpageCard eachCard = new PlannermainpageCard();
            if(requirement.getQ7Estimate()==500){
                eachCard.setEstimate("~500만원");
            }else if(requirement.getQ7Estimate()==1000){
                eachCard.setEstimate("500만원~1000만원");
            }else if(requirement.getQ7Estimate()==1500){
                eachCard.setEstimate("1000만원~1500만원");
            }else if(requirement.getQ7Estimate()==2000){
                eachCard.setEstimate("1500만원~2000원");
            }else if(requirement.getQ7Estimate()==9999){
                eachCard.setEstimate("상관없음");
            }

            eachCard.setCity(requirement.getQ1City());
            eachCard.setGu(requirement.getQ1Gu());
            System.out.println("요구서 번호 : " + requirement.getRequirementNo());
            Member member = memberRepository.findByRequirementPk((int)requirement.getRequirementNo());
            eachCard.setMemberPk(member.getMemberNo());
            eachCard.setMemberName(member.getName());
            eachCard.setRequirementPk(requirement.getRequirementNo());
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
