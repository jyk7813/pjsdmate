package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
@RequestMapping("/planner")
public class PlannerController {

    private final PlannerService plannerService;

    public PlannerController(PlannerService plannerService) {
        this.plannerService = plannerService;
    }

    @GetMapping("/main")
    public String mainplanner() {
        return "mainplanner";
    }
    @GetMapping("/join")
    public String join() { return "planner_join"; }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String Login(@RequestParam String id, @RequestParam String pw,@RequestParam String userstat, Model
            model, HttpSession session, HttpServletResponse response){
        Planner planner = plannerService.login(id, pw);
        if(planner !=null){

            if((model.getAttribute("AutoLogin") != null)){
                Cookie cookie = new Cookie("id",planner.getId());
                response.addCookie(cookie);
            }
            session.setAttribute("planner",planner);

            session.setAttribute("userPk",planner.getPlannerNo());
            return "redirect:/planner/main";
        }else{
            model.addAttribute("error","로그인 실패");

        }

        if(userstat.equals("planner")){
            session.setAttribute("userstat","planner");
            return "redirect:/planner/login?userstat=planner";
        } else if (userstat.equals("member")) {
            session.setAttribute("userstat","member");
            return "redirect:./member/login";
        }
        return "redirect:./login?userstat=planner";
    }

    @PostMapping("/join")
    public String Join(Model model){
        String json = (String)model.getAttribute("planner");

        plannerService.join(json);
        return "login";
    }
}


