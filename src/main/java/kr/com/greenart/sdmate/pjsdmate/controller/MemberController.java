package kr.com.greenart.sdmate.pjsdmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/")
    public String start(){
        return "start";
    }
    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/answer")
    public String answer() {
        return "answer";
    }
}
