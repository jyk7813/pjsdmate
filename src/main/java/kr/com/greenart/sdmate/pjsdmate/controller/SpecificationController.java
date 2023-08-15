package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.*;

import kr.com.greenart.sdmate.pjsdmate.service.*;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

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


    private final MemberService memberService;
    public SpecificationController(SpecificationService specificationService, RequirementService requirementService, MySpecificationService mySpecificationService, PlannerService plannerService, MemberService memberService) {
        this.specificationService = specificationService;
        this.requirementService = requirementService;
        this.mySpecificationService = mySpecificationService;
        this.plannerService = plannerService;
        this.memberService = memberService;
    }

    @GetMapping("/viewSpecification")
    public String viewSpecification(@RequestParam String specification, Model model){

        Specification objSpecification =  specificationService.getSpecificationByNo(Integer.parseInt(specification));
        int sum = objSpecification.calculateSumExceptSpecNoAndState();
        Requirement requirement = requirementService.getRequirementByNo(objSpecification.getRequirement_no());
        Member member = memberService.getRequirement(requirement.getRequirementNo());
        SendRequirement sendRequirement = requirementService.setttingRequirement(requirement);

        SendSpecification sendSpecification = new SendSpecification();
        SendSpecification send = sendSpecification.setting(sendSpecification,objSpecification);

        String settingSum =sendSpecification.format(sum);

        Planner planner = plannerService.findBySepcificationInPackage(objSpecification.getSpecificationNo());



        model.addAttribute("sum",settingSum);

        model.addAttribute("planner", planner);
        model.addAttribute("member",member);
        model.addAttribute("specification",send);
        model.addAttribute("requirement",sendRequirement);
        return "estimate_member";
    }
//    @GetMapping("/plannerInfo")
//    public String plannerInfo(){
//        return "plannerInfo";
//    }
    @PostMapping ("/plannerInfo")
    public String plannerInfo(@RequestParam String id, Model model){
        Planner planner = plannerService.getPlannerByUsername(id);

        model.addAttribute("planner", planner);
        return "planner";
    }
    @GetMapping("/userInfo")
    public  String viewUser(){
        return "userInfo";
    }


    @GetMapping("/viewMySpecification")
    public String Myspecification(@RequestParam String specificationNo, String requirementNo, Model model) throws IOException {

        int plannerNo = mySpecificationService.returnPlannerNoBySpeNo(Integer.parseInt(specificationNo));
        Planner planner = plannerService.getPlannerById(plannerNo);
        Specification specification = mySpecificationService.returnSpecification(Integer.parseInt(specificationNo));
        Requirement requirement = mySpecificationService.returnRequirement(Integer.parseInt(requirementNo));
        Member member = mySpecificationService.returnMember(Integer.parseInt(requirementNo));
        SendRequirement sendRequirement = new SendRequirement();
        sendRequirement.setting(sendRequirement, requirement);
        SendSpecification sendSpecification = new SendSpecification();
        sendSpecification.setting(sendSpecification, specification);
        String encoded=null;
        try {
            encoded = Base64.getEncoder().encodeToString(member.getImage());
        } catch (NullPointerException e) {
            String imagePath = "src/main/resources/static/img/profileDefault.png"; // 이미지 파일 경로
            Path path = Paths.get(imagePath);
            byte[] imageBytes = Files.readAllBytes(path);
            encoded = Base64.getEncoder().encodeToString(imageBytes);
        }

        model.addAttribute("planner", planner);
        model.addAttribute("specification", sendSpecification);
        model.addAttribute("requirement", sendRequirement);
        model.addAttribute("member", member);
        model.addAttribute("encoded", encoded);

        return "estimate_planner_check";
    }
    @PostMapping("/saveSpecification")
    public ResponseEntity<String> saveSpecification(@RequestBody Specification specification, HttpSession session){
        Planner planner = (Planner) session.getAttribute("planner");
        Member member = memberService.getRequirement(specification.getRequirement_no());
        specificationService.save(specification,planner,member);

        return ResponseEntity.ok("데이터가 성공적으로 저장되었습니다");
    }

    @PostMapping("/checkState")
    public ResponseEntity<String> checkState(@RequestBody String specificationNo){

        Specification specificationByNo = specificationService.getSpecificationByNo(Integer.parseInt(specificationNo));

        return ResponseEntity.ok(""+specificationByNo.getState());
    }
}
