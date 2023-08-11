package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.service.RequirementService;
import kr.com.greenart.sdmate.pjsdmate.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpecificationController {

    private final SpecificationService specificationService;
    private final RequirementService requirementService;
    public SpecificationController(SpecificationService specificationService, RequirementService requirementService) {
        this.specificationService = specificationService;
        this.requirementService = requirementService;
    }

    @GetMapping("/viewSpecification")
    public String viewSpecification(@RequestParam String specification, Model model){

    Specification objSpecification =  specificationService.getSpecificationByNo(Integer.parseInt(specification));
    int sum = objSpecification.calculateSumExceptSpecNoAndState();
    Requirement requirement = requirementService.getRequirementByNo(objSpecification.getRequirement_no());
    System.out.println(requirement);
    model.addAttribute("sum",sum);
    model.addAttribute("specification",objSpecification);
    model.addAttribute("requirement",requirement);
    return "estimate_member";
    }
    @GetMapping("/plannerInfo")
    public String plannerInfo(){
    return "plannerInfo";
    }
}
