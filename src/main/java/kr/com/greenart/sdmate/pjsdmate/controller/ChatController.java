package kr.com.greenart.sdmate.pjsdmate.controller;


import kr.com.greenart.sdmate.pjsdmate.domain.ChatHistory;
import kr.com.greenart.sdmate.pjsdmate.domain.Mchat;
import kr.com.greenart.sdmate.pjsdmate.domain.Pchat;
import kr.com.greenart.sdmate.pjsdmate.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class ChatController {
    private final ChatService chatService;
    private final PlannerService plannerService;

    private final MemberService memberService;

    public ChatController(ChatService chatService, PlannerService plannerService, MemberService memberService) {
        this.chatService = chatService;
        this.plannerService = plannerService;
        this.memberService = memberService;
    }

    @GetMapping("/memberChat")
    public String memberChat(            @RequestParam(name = "memberNo", required = false) String memberNo,
                                         @RequestParam(name = "plannerNo", required = false) String plannerNo,
                                         @RequestParam(name = "message", required = false) String message, Model model){
        try {
            if(message.length() != 0 ) {
                Mchat mchat = new Mchat();
                mchat.setContent(message);
                mchat.setMemberNo(Integer.parseInt(memberNo));
                mchat.setPlannerNo(Integer.parseInt(plannerNo));
                mchat.setDatetime(new Timestamp(System.currentTimeMillis()));
                mchat.setView(0);
                chatService.saveMessage(mchat);
            }
        } catch (NullPointerException e) {

        }
        List<ChatHistory> histories = chatService.getChatHistory(Integer.parseInt(memberNo), Integer.parseInt(plannerNo));
        String plannerName = plannerService.getPlannerById(Integer.parseInt(plannerNo)).getName();
        model.addAttribute("plannerName", plannerName);
        model.addAttribute("histories", histories);
        model.addAttribute("memberNo", memberNo);
        model.addAttribute("plannerNo", plannerNo);
        return "Mchat";
    }

    @GetMapping("/plannerChat")
    public String plannerChat(            @RequestParam(name = "memberNo", required = false) String memberNo,
                                         @RequestParam(name = "plannerNo", required = false) String plannerNo,
                                         @RequestParam(name = "message", required = false) String message, Model model){
        try {
            if(message.length() != 0 ) {
                Pchat pchat = new Pchat();
                pchat.setContent(message);
                pchat.setMemberNo(Integer.parseInt(memberNo));
                pchat.setPlannerNo(Integer.parseInt(plannerNo));
                pchat.setDatetime(new Timestamp(System.currentTimeMillis()));
                pchat.setView(0);
                chatService.savePMessage(pchat);
            }
        } catch (NullPointerException e) {

        }
        List<ChatHistory> histories = chatService.getChatHistory(Integer.parseInt(memberNo), Integer.parseInt(plannerNo));
        String memberName = memberService.getMemberByPK(Integer.parseInt(memberNo)).getName();
        int requirementNo =  memberService.getMemberByPK(Integer.parseInt(memberNo)).getRequirementPk();
        int specificationNo = chatService.returnSpeNo(Integer.parseInt(memberNo), Integer.parseInt(plannerNo));


        model.addAttribute("requirementNo", requirementNo);
        model.addAttribute("specificationNo", specificationNo);
        model.addAttribute("memberName", memberName);
        model.addAttribute("histories", histories);
        model.addAttribute("memberNo", memberNo);
        model.addAttribute("plannerNo", plannerNo);
        return "Pchat";
    }
}

