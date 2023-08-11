package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;
import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerSpecificationPackageRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.ReviewRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainPageService {
    private final PlannerRepository plannerRepository;
    private final SpecificationRepository specificationRepository;
    private final ReviewRepository reviewRepository;

    private final PlannerSpecificationPackageRepository plannerSpecificationPackageRepository;

    @Autowired
    public MainPageService(PlannerRepository plannerRepository, SpecificationRepository specificationRepository, ReviewRepository reviewRepository, PlannerSpecificationPackageRepository plannerSpecificationPackageRepository) {
        this.plannerRepository = plannerRepository;
        this.specificationRepository = specificationRepository;
        this.reviewRepository = reviewRepository;
        this.plannerSpecificationPackageRepository = plannerSpecificationPackageRepository;
    }

    public List<PlannerSpecificationPackage> getpackageByPk(int memberNo) {
        return plannerSpecificationPackageRepository.findByMemberNo(memberNo);
    }
    public List<mainpageCard> card = new ArrayList<>();
    public List<mainpageCard> returnMainCard(int memberNo) {

        card = new ArrayList<>();
        List<PlannerSpecificationPackage> packageList = getpackageByPk(memberNo);

        List<Integer> plannerNumbers = packageList.stream()
                .sorted((p1, p2) -> p2.getDatetime().compareTo(p1.getDatetime()))
                .map(PlannerSpecificationPackage::getPlannerNo)
                .collect(Collectors.toList());

        for (Integer plannerNumber : plannerNumbers) {
            mainpageCard eachCard = new mainpageCard();
            Planner planner = plannerRepository.findByplannerNo(plannerNumber).get();
            eachCard.setPlannerPk(planner.getPlannerNo());
            eachCard.setBusinessName(planner.getBusiness_name());
            eachCard.setDealCnt(planner.getDealCnt());
            eachCard.setRating(planner.getRating());
            String encoded = Base64.getEncoder().encodeToString(planner.getImage());
            eachCard.setPlannerImg(encoded);
//            System.out.println(encoded);

            for (PlannerSpecificationPackage packageItem : packageList) {
                if (packageItem.getPlannerNo() == plannerNumber) {
                    Specification specification = specificationRepository.findBySpecificationNo(packageItem.getSpecificationNo()).get();
                    eachCard.setSum(specification.calculateSumExceptSpecNoAndState());
                }
            }
            eachCard.setReviewCnt(reviewRepository.countByplannerNo(plannerNumber));
            card.add(eachCard);
        }
        return card;
    }
}
