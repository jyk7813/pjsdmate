package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.domain.SendRequirement;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import kr.com.greenart.sdmate.pjsdmate.service.RequirementService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RequirementController {

    private final RequirementService requirementService;
    private final MemberService memberService;

    public RequirementController(RequirementService requirementService, MemberService memberService) {
        this.requirementService = requirementService;
        this.memberService = memberService;
    }

    @PostMapping("/requirement/insert")
    public String insertRequirement() {
        // session에 있는 id pk 값을 가져와야함
        // Requirement requirement = new Requirement();
        // json 형태로 받아서 requirement에 넣어야함
        // requirementService.insertRequirement(requirement);

        return "redirect:/main";
    }

    @GetMapping("/viewRequirement")
    public String viewRequirement(@RequestParam String requirement, Model model, HttpSession session){
        if(session.getAttribute("planner") ==null){
            return "redirect:/planner/login";
        }
        int RequirmentPk = Integer.parseInt(requirement);
        Requirement GetRequirement = requirementService.getRequirementByNo(RequirmentPk);
        Member member = memberService.getRequirement(RequirmentPk);

        SendRequirement sendRequirement = new SendRequirement();
        sendRequirement.setting(sendRequirement,GetRequirement);

        System.out.println(sendRequirement.getQ2_dress());
        model.addAttribute("member",member);
        model.addAttribute("requirement",sendRequirement);

        return "estimate_planner";
    }
    @GetMapping("/except")
    public String except(){
        return "except";
    }
}
