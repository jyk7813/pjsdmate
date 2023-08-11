package kr.com.greenart.sdmate.pjsdmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpecificationController {
@GetMapping("/viewSpecification")
    public String viewSpecification(){
        return "estimate_member";
    }
    @GetMapping("/plannerInfo")
    public String plannerInfo(){
    return "plannerInfo";
    }
}
