package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.domain.SendRequirement;
import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.service.MySpecificationService;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;
import kr.com.greenart.sdmate.pjsdmate.service.RequirementService;
import kr.com.greenart.sdmate.pjsdmate.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Controller
public class SpecificationController {

    private final SpecificationService specificationService;
    private final RequirementService requirementService;

    private final MySpecificationService mySpecificationService;

    private final PlannerService plannerService;
    public SpecificationController(SpecificationService specificationService, MySpecificationService.RequirementService requirementService, MySpecificationService mySpecificationService, PlannerService plannerService) {
        this.specificationService = specificationService;
        this.requirementService = requirementService;
        this.mySpecificationService = mySpecificationService;
        this.plannerService = plannerService;
    }

    @GetMapping("/viewSpecification")
    public String viewSpecification(@RequestParam String specification, Model model){

    Specification objSpecification =  specificationService.getSpecificationByNo(Integer.parseInt(specification));
    int sum = objSpecification.calculateSumExceptSpecNoAndState();
    Requirement requirement = requirementService.getRequirementByNo(objSpecification.getRequirement_no());

    SendRequirement sendRequirement = requirementService.setttingRequirement(requirement);

    Planner planner = plannerService.findBySepcificationInPackage(objSpecification.getSpecificationNo());

    System.out.println(requirement);
    model.addAttribute("sum",sum);
    model.addAttribute("planner", planner);
    model.addAttribute("specification",objSpecification);
    model.addAttribute("requirement",sendRequirement);
    return "estimate_member";
    }
    @GetMapping("/plannerInfo")
    public String plannerInfo(){
    return "plannerInfo";
    }
    @GetMapping("/userInfo")
    public  String viewUser(){
        return "userInfo";
    }


    @GetMapping("/viewMySpecification")
    public String Myspecification(@RequestParam String specificationNo, String requirementNo, Model model) throws IOException {

        Specification specification = mySpecificationService.returnSpecification(Integer.parseInt(specificationNo));
        Requirement requirement = mySpecificationService.returnRequirement(Integer.parseInt(requirementNo));
        Member member = mySpecificationService.returnMember(Integer.parseInt(requirementNo));

        String encoded=null;
        try {
            encoded = Base64.getEncoder().encodeToString(member.getImage());
        } catch (NullPointerException e) {
            String imagePath = "src/main/resources/static/img/profileDefault.png"; // 이미지 파일 경로
            Path path = Paths.get(imagePath);
            byte[] imageBytes = Files.readAllBytes(path);
            encoded = Base64.getEncoder().encodeToString(imageBytes);
        }
        model.addAttribute("specification", specification);
        model.addAttribute("requirement", requirement);
        model.addAttribute("member", member);
        model.addAttribute("encoded", encoded);

        return "estimate_planner_check";
    }
}
