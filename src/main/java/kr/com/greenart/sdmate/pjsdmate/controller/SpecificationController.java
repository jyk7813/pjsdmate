package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.service.MySpecificationService;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;
import kr.com.greenart.sdmate.pjsdmate.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpecificationController {

    private final SpecificationService specificationService;
    private final MySpecificationService.RequirementService requirementService;

    private final PlannerService plannerService;
    public SpecificationController(SpecificationService specificationService, MySpecificationService.RequirementService requirementService, PlannerService plannerService) {
        this.specificationService = specificationService;
        this.requirementService = requirementService;
        this.plannerService = plannerService;
    }

    @GetMapping("/viewSpecification")
    public String viewSpecification(@RequestParam String specification, Model model){

    Specification objSpecification =  specificationService.getSpecificationByNo(Integer.parseInt(specification));
    int sum = objSpecification.calculateSumExceptSpecNoAndState();
    Requirement requirement = requirementService.getRequirementByNo(objSpecification.getRequirement_no());


    Planner planner = plannerService.findBySepcificationInPackage(objSpecification.getSpecificationNo());

    System.out.println(requirement);
    model.addAttribute("sum",sum);
    model.addAttribute("planner", planner);
    model.addAttribute("specification",objSpecification);
    model.addAttribute("requirement",requirement);
    return "estimate_member";
    }
    @GetMapping("/plannerInfo")
    public String plannerInfo(){
    return "plannerInfo";
    }

    @GetMapping("/viewMySpecification")
    public String Myspecification(){
        return "estimate_planner_check";
    }
}
