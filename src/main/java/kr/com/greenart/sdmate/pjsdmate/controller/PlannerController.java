package kr.com.greenart.sdmate.pjsdmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PlannerController {

    @GetMapping("/planner/join")
    public String join() { return "planner_join"; }

}


