package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Need;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;
import kr.com.greenart.sdmate.pjsdmate.service.SpecificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@Controller
public class ReviewController {

    private final SpecificationService specificationService;
    private final PlannerService plannerService;

    public ReviewController(SpecificationService specificationService, PlannerService plannerService) {
        this.specificationService = specificationService;
        this.plannerService = plannerService;
    }

    @GetMapping("/LastReview")
    public String LastReview(){
        return "LastReview";
    }
    @GetMapping("/review")
    public String review(){
        return "review";
    }
    @PostMapping("/sendReview")
    public ResponseEntity<String> sendReview(@RequestBody Need need, HttpSession session){
        session.setAttribute("need",need);
        return ResponseEntity.ok("잘됐습니다");
    }
    @GetMapping("/sendReview")
    public String sendReview(){

        return "sendreview";
    }
    @PostMapping("/sendLastReview")
    public  ResponseEntity<String> sendLastReview(@RequestBody Need need,HttpSession session){
        session.setAttribute("need",need);
        System.out.println(need.getSpecification());
        System.out.println(need.getRating());
        return ResponseEntity.ok("잘됐습니다");
    }
    @GetMapping("/sendLastReview")
    public String sendLastReview(){
        return "sendLastReview";
    }
    @GetMapping("/reviewCenter")
    public String reviewCenter(){
        return "reviewCenter";
    }

    @GetMapping("/YesContact")
    public String doContact(HttpSession session){
        Need need =(Need)session.getAttribute("need");

        specificationService.updataState(need.getSpecification(), 1);
        plannerService.updataRating(need.getRating(), need.getSpecification());
        return "redirect:/member/main";
    }
    @GetMapping("/YesLastContact")
    public String endContact(HttpSession session){
        Need need =(Need)session.getAttribute("need");


        specificationService.updataState(need.getSpecification(), 2);
        plannerService.updataLastRating(need.getRating(), need.getSpecification());
        return "redirect:/member/main";
    }
}
