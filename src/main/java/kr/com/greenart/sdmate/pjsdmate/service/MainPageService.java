package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.ReviewRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainPageService {
    private final PlannerRepository plannerRepository;
    private final SpecificationRepository specificationRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public MainPageService(PlannerRepository plannerRepository, SpecificationRepository specificationRepository, ReviewRepository reviewRepository) {
        this.plannerRepository = plannerRepository;
        this.specificationRepository = specificationRepository;
        this.reviewRepository = reviewRepository;
    }

    public mainpageCard returnMainCard(int memberNo) {
        mainpageCard card = null;


        return card;
    }


//    public List<mainpageCard> returnMainCardList(int memberNo) {
//        List<mainpageCard> list = null;
//
//
//
//        return list;
//    }
//    public int forCnt(int memberNo) {
//
//    }

}
