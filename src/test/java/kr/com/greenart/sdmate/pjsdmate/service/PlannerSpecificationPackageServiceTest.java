package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.*;
import kr.com.greenart.sdmate.pjsdmate.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class PlannerSpecificationPackageServiceTest {

    @Autowired
    MainPageService mainPageService;
    @Autowired
    PlannerMainPageService plannerMainPageService;
    @Autowired
    PlannerSpecificationPackageRepository plannerSpecificationPackageRepository;
    @Autowired
    PlannerRepository plannerRepository;
    @Autowired
    SpecificationRepository specificationRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    RequirementRepository requirementRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 플래너카드리스트리턴받기() throws IOException {
        List<PlannermainpageCard> list = plannerMainPageService.returnPlannerMainCard(2);

        for(PlannermainpageCard plannermainpageCard : list) {
            System.out.println(plannermainpageCard);
        }
//
//        int plannerNo = 2;
//       List<PlannermainpageCard> card = new ArrayList<>();
//
//        Planner planner = plannerRepository.findByplannerNo(plannerNo).get();
//        String region = planner.getRegion();
//        List<Requirement> requirementList = requirementRepository.findByQ1CityOrderByQ1DateAsc(region);
//        for (Requirement requirement : requirementList) {
//            System.out.println("혹시여기니?" + requirement);
//            PlannermainpageCard eachCard = new PlannermainpageCard();
//            eachCard.setEstimate(requirement.getQ7Estimate());
//            eachCard.setCity(requirement.getQ1City());
//            eachCard.setGu(requirement.getQ1Gu());
//            Member member = memberRepository.findByRequirementPk(requirement.getRequirementNo());
//            eachCard.setMemberPk(member.getMemberNo());
//            eachCard.setMemberName(member.getName());
//            String encoded = Base64.getEncoder().encodeToString(member.getImage());
//            eachCard.setMemberImg(encoded);
//            card.add(eachCard);
//        }
//
//        for(PlannermainpageCard plannermainpageCard : card) {
//            System.out.println(plannermainpageCard);
//        }
    }

    @Test
    void 리스트리턴받기() {
//        List<mainpageCard> card = new ArrayList<>();
//
//        List<PlannerSpecificationPackage> packageList = plannerSpecificationPackageRepository.findByMemberNo(1);
//
//        List<Integer> plannerNumbers = packageList.stream()
//                .sorted((p1, p2) -> p2.getDatetime().compareTo(p1.getDatetime()))
//                .map(PlannerSpecificationPackage::getPlannerNo)
//                .collect(Collectors.toList());
//
//        Integer plannerNumber = 1;
//        mainpageCard eachCard = new mainpageCard();
//        Planner planner = plannerRepository.findByplannerNo(plannerNumber).get();
//
//        eachCard.setPlannerPk(planner.getPlannerNo());
//        eachCard.setBusinessName(planner.getBusiness_name());
//        eachCard.setDealCnt(planner.getDealCnt());
//        eachCard.setRating(planner.getRating());
//        eachCard.setPlannerImg(planner.getImage());
//
//        for (PlannerSpecificationPackage packageItem : packageList) {
//            if (packageItem.getPlannerNo() == plannerNumber) {
//                Specification specification = specificationRepository.findBySpecificationNo(packageItem.getSpecificationNo()).get();
//                eachCard.setSum(specification.calculateSumExceptSpecNoAndState());
//            }
//        }
//        eachCard.setReviewCnt(reviewRepository.countByplannerNo(plannerNumber));
//        System.out.println(plannerNumbers);



        List<PlannerSpecificationPackage> list = mainPageService.getpackageByPk(1);


        System.out.print(list);
    }

    @Test
    void 카드리턴받기() {
        List<mainpageCard> card = mainPageService.returnMainCard(1);
        System.out.print("제발!!!!!!!!!!!!!!!!!!!" + card.size());
    }

}
