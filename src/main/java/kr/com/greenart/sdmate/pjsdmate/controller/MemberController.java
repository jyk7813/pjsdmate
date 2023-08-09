package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;
import kr.com.greenart.sdmate.pjsdmate.domain.mainplannerpageCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @GetMapping("/main")
    public String main(HttpSession session) {
        mainpageCard card = new mainpageCard();
        card.setSum(3000000);
        card.setBusinessName("테스트사업");
        card.setDealCnt(48);
        card.setRating((long) 2.8);
        card.setPlannerPk(1);
        card.setPlannerImg(null);
        card.setReviewCnt(3);
        System.out.println(card);
        session.setAttribute("card", card);


//        @GetMapping("/answer")
//        public String answer () {
//            return "answer";
//        }
//        @GetMapping("/login")
//        public String login () {
//            return "login";
//        }
//        @GetMapping("/")
//        public String start () {
//            return "start";
//        }
//        @GetMapping("/main")
//        public String main () {
//            return "main";
//        }
        return "main";
    }

    @GetMapping("/mainplanner")
    public String mainplanner() {
        return "mainplanner";
    }


    @GetMapping("/mainyxxn")
    public String mainyxxn(Model model) {
        List<mainpageCard> cardList = new ArrayList<>();

        for(int i = 1; i < 4; i++){
            mainpageCard card = new mainpageCard();
            card.setSum(3000000+i);
            card.setBusinessName("테스트사업"+i);
            card.setDealCnt(48+i);
            card.setRating((long) 2.8+i);
            card.setPlannerPk(1+i);
            card.setPlannerImg(null);
            card.setReviewCnt(3+i);
            System.out.println(card);
            cardList.add(card);
        }
        model.addAttribute("cardList", cardList);

        return "main";
    }

    @GetMapping("/mainplanneryxxn")
    public String mainplanneryxxn(Model model) {
        List<mainplannerpageCard> plannercardList = new ArrayList<>();

        for(int i = 1; i < 4; i++){
            mainplannerpageCard card = new mainplannerpageCard();
            card.setPrice(3000000+i);
            card.setMemberPk(i);
            card.setMemberName("테스트"+i);
            card.setArea("서울"+i);
            System.out.println(card);
            plannercardList.add(card);
        }
        model.addAttribute("plannercardList", plannercardList);

        return "mainplanner";
    }
}