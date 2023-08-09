package kr.com.greenart.sdmate.pjsdmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planner")
public class PlannerController {

    @GetMapping("/join")
    public String join() { return "planner_join"; }

}


