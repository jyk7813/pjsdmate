package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.PlannermainpageCard;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class PlannerMainPageService {
    private final PlannerRepository plannerRepository;
    private final RequirementRepository requirementRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public PlannerMainPageService(PlannerRepository plannerRepository, RequirementRepository requirementRepository, MemberRepository memberRepository) {
        this.plannerRepository = plannerRepository;
        this.requirementRepository = requirementRepository;
        this.memberRepository = memberRepository;
    }

    public List<PlannermainpageCard> card = new ArrayList<>();

    public List<PlannermainpageCard> returnPlannerMainCard(int plannerNo) {
        card = new ArrayList<>();

        Planner planner = plannerRepository.findByplannerNo(plannerNo).get();
        String region = planner.getRegion();
        List<Requirement> requirementList = requirementRepository.findByQ1CityOrderByQ1DateAsc(region);
        for (Requirement requirement : requirementList) {
            PlannermainpageCard eachCard = new PlannermainpageCard();
            eachCard.setEstimate(requirement.getQ7Estimate());
            eachCard.setCity(requirement.getQ1City());
            eachCard.setGu(requirement.getQ1Gu());
            Member member = memberRepository.findByRequirementPk(requirement.getRequirementNo());
            eachCard.setMemberPk(member.getMemberNo());
            eachCard.setMemberName(member.getName());
            String encoded = Base64.getEncoder().encodeToString(member.getImage());
            eachCard.setMemberImg(encoded);
            card.add(eachCard);
        }
        return card;
    }
}
