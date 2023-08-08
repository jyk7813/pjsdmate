package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @PostMapping("/main")
    public String main(Model model) {
        mainpageCard card = new mainpageCard();
        card.setSum(3000000);
        card.setBusinessName("테스트사업");
        card.setDealCnt(48);
        card.setRating((long) 2.8);
        card.setPlannerPk(1);
        card.setPlannerImg(null);
        card.setReviewCnt(3);
        model.addAttribute("card", card);
        return "main";
    }
}
