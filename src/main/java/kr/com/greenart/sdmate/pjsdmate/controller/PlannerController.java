package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/planner")
public class PlannerController {

    @GetMapping("/main")
    public String main(Model model) {

//        List<mainpageCard> card = mainPageService.returnMainCard(1);
//
//        model.addAttribute("card", card);

        return "main";
    }


    @GetMapping("/join")
    public String join() { return "planner_join"; }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}


