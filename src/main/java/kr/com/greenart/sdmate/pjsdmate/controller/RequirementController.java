package kr.com.greenart.sdmate.pjsdmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequirementController {

    @PostMapping("/requirement/insert")
    public String insertRequirement() {
        // session에 있는 id pk 값을 가져와야함
        // Requirement requirement = new Requirement();
        // json 형태로 받아서 requirement에 넣어야함
        // requirementService.insertRequirement(requirement);

        return "redirect:/main";
    }

    @GetMapping("/viewRequirement")
    public String viewRequirement(){


        return "estimate_planner";
    }
    @GetMapping("/except")
    public String except(){
        return "except";
    }
}
