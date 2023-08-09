package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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
}