package kr.com.greenart.sdmate.pjsdmate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {



    @GetMapping("/memberChat")
    public String memberChat(){

        return "Mchat";
    }
}
