package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.*;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerSpecificationPackageRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.ReviewRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public List<mainpageCard> returnMainCard(int memberNo) throws IOException {
        int cnt=0;
        int rePlannerNo=0;
        int endCnt=0;
        card = new ArrayList<>();
        List<PlannerSpecificationPackage> packageList = getpackageByPk(memberNo);
        for (PlannerSpecificationPackage plannerSpecificationPackage : packageList) {
            Specification specification = specificationRepository.findBySpecificationNo(plannerSpecificationPackage.getSpecificationNo()).get();
            if(specification.getState() == 1) {
                rePlannerNo = plannerSpecificationPackage.getPlannerNo();
                cnt++;
            }
        }

        List<Integer> plannerNumbers = packageList.stream()
                .sorted((p1, p2) -> p2.getDatetime().compareTo(p1.getDatetime()))
                .map(PlannerSpecificationPackage::getPlannerNo)
                .collect(Collectors.toList());

        if (cnt == 0) {
            for (Integer plannerNumber : plannerNumbers) {
                mainpageCard eachCard = new mainpageCard();
                Planner planner = plannerRepository.findByplannerNo(plannerNumber).get();
                eachCard.setPlannerPk(planner.getPlannerNo());
                eachCard.setBusinessName(planner.getBusiness_name());
                eachCard.setDealCnt(planner.getDealCnt());
                eachCard.setRating(planner.getRating());
                String encoded = null;
                try {
                    encoded = Base64.getEncoder().encodeToString(planner.getImage());
                } catch (NullPointerException e) {
                    String imagePath = "src/main/resources/static/img/profileDefault.png"; // 이미지 파일 경로
                    Path path = Paths.get(imagePath);
                    byte[] imageBytes = Files.readAllBytes(path);
                    encoded = Base64.getEncoder().encodeToString(imageBytes);
                } finally {
                    eachCard.setPlannerImg(encoded);
                }
                for (PlannerSpecificationPackage packageItem : packageList) {
                    if (packageItem.getPlannerNo() == plannerNumber) {
                        Specification specification = specificationRepository.findBySpecificationNo(packageItem.getSpecificationNo()).get();
                        eachCard.setSpecificationNo(specification.getSpecificationNo());
                        SendSpecification sendSpecification = new SendSpecification();
                        eachCard.setSum(sendSpecification.format(specification.calculateSumExceptSpecNoAndState()));
                    }
                }
                eachCard.setReviewCnt(reviewRepository.countByplannerNo(plannerNumber));





                card.add(eachCard);
            }
        } else {
            int plannerNumber = rePlannerNo;
            mainpageCard eachCard = new mainpageCard();
            Planner planner = plannerRepository.findByplannerNo(plannerNumber).get();
            eachCard.setPlannerPk(planner.getPlannerNo());
            eachCard.setBusinessName(planner.getBusiness_name());
            eachCard.setDealCnt(planner.getDealCnt());
            eachCard.setRating(planner.getRating());

            String encoded = null;
            try {
                encoded = Base64.getEncoder().encodeToString(planner.getImage());
            } catch (NullPointerException e) {
                String imagePath = "src/main/resources/static/img/profileDefault.png"; // 이미지 파일 경로
                Path path = Paths.get(imagePath);
                byte[] imageBytes = Files.readAllBytes(path);
                encoded = Base64.getEncoder().encodeToString(imageBytes);
            } finally {
                eachCard.setPlannerImg(encoded);
            }


            for (PlannerSpecificationPackage packageItem : packageList) {
                if (packageItem.getPlannerNo() == plannerNumber) {
                    Specification specification = specificationRepository.findBySpecificationNo(packageItem.getSpecificationNo()).get();
                    eachCard.setSpecificationNo(specification.getSpecificationNo());
                    SendSpecification sendSpecification = new SendSpecification();
                    eachCard.setSum(sendSpecification.format(specification.calculateSumExceptSpecNoAndState()));
                }
            }
            eachCard.setReviewCnt(reviewRepository.countByplannerNo(plannerNumber));
            card.add(eachCard);
        }
         cnt=0;
        rePlannerNo=0;
        endCnt=0;
        return card;
    }
}
