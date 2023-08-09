package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;
import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerSpecificationPackageRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.ReviewRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class PlannerSpecificationPackageServiceTest {

    @Autowired
    MainPageService mainPageService;
    @Autowired
    PlannerSpecificationPackageRepository plannerSpecificationPackageRepository;
    @Autowired
    PlannerRepository plannerRepository;
    @Autowired
    SpecificationRepository specificationRepository;
    @Autowired
    ReviewRepository reviewRepository;

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
