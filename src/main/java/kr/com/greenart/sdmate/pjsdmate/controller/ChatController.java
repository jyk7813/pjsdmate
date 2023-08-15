package kr.com.greenart.sdmate.pjsdmate.controller;


import kr.com.greenart.sdmate.pjsdmate.domain.ChatHistory;
import kr.com.greenart.sdmate.pjsdmate.domain.Mchat;
import kr.com.greenart.sdmate.pjsdmate.domain.Pchat;
import kr.com.greenart.sdmate.pjsdmate.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
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

        model.addAttribute("histories", histories);
        model.addAttribute("memberNo", memberNo);
        model.addAttribute("plannerNo", plannerNo);
        return "Pchat";
    }
}

