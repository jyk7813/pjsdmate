package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.MySpecification;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.PlannermainpageCard;
import kr.com.greenart.sdmate.pjsdmate.service.MySpecificationService;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerMainPageService;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Controller
@RequestMapping("/planner")
public class PlannerController {

    private final PlannerService plannerService;
    private final PlannerMainPageService plannerMainPageService;

    private final MySpecificationService mySpecificationService;

    public PlannerController(PlannerService plannerService, PlannerMainPageService plannerMainPageService, MySpecificationService mySpecificationService) {
        this.plannerService = plannerService;
        this.plannerMainPageService = plannerMainPageService;
        this.mySpecificationService = mySpecificationService;
    }
    @GetMapping("/viewMySpecification")
    public String mySpecification(@RequestParam(name = "plannerNo", required = false) String plannerNo, Model model,HttpSession session) throws IOException {
        if(session.getAttribute("planner") ==null){
            return "redirect:./login";
        }
        List<MySpecification> cardList;
        cardList = mySpecificationService.returnMySpeList(Integer.parseInt(plannerNo));
        model.addAttribute("cardList", cardList);
        return "mySpecification";
    }
    @GetMapping("/main")
    public String mainplanner(Model model, HttpSession session) throws IOException {

        Planner planner = (Planner) session.getAttribute("planner");
        List<PlannermainpageCard> card = plannerMainPageService.returnPlannerMainCard(planner.getPlannerNo());

        model.addAttribute("planner", planner);
        model.addAttribute("card", card);
        return "mainplanner";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String Login(@RequestParam String id, @RequestParam String pw, @RequestParam String userstat, Model
            model, HttpSession session, HttpServletResponse response, HttpServletRequest request){
        if(userstat.equals("planner,member")||userstat.equals("member")) {
            try {
                request.setAttribute("id", id);
                request.setAttribute("pw", pw);
                request.getRequestDispatcher("/member/login").forward(request, response);
                return "forward:/member/login";
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Planner planner = plannerService.login(id, pw);
            if (planner != null) {

                if ((model.getAttribute("AutoLogin") != null)) {
                    Cookie cookie = new Cookie("id", planner.getId());
                    response.addCookie(cookie);
                }
                session.setAttribute("planner", planner);

                return "redirect:/planner/main";

            } else {
                model.addAttribute("error", "로그인 실패");

            }
        }

        return "redirect:./login?userstat=planner";
    }
    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("planner", new Planner());
        return "planner_join";
    }

    @PostMapping("/join")
    public String Join(@Valid @ModelAttribute("planner") Planner planner, BindingResult result, Model model){
        if(result.hasErrors()){
            return "planner_join";
        }
        // 이메일 중복 검사
        if (plannerService.isEmailDuplicated(planner.getEmail())){
            result.rejectValue("email", "Duplicated" , "이미 사용중인 이메일 입니다.");
        }
        // 아이디 중복 검사
        if (plannerService.isIdDuplicated(planner.getId())){
            result.rejectValue("id", "Duplicated" , "이미 사용중인 아이디 입니다.");
        }
        // 사업자 번호 중복 검사
        if (plannerService.isBusinessNoDuplicated(planner.getBusiness_no())){
            result.rejectValue("business_no", "Duplicated" , "이미 사용중인 사업자 번호 입니다.");
        }
        // 전화번호 중복 검사
        if (plannerService.isPhoneNoDuplicated(planner.getPhonenum())){
            result.rejectValue("phonenum", "Duplicated" , "이미 사용중인 전화번호 입니다.");
        }
        if(result.hasErrors()){
            return "planner_join";
        }

        plannerService.join(planner);
        return "redirect:/planner/login?userstat=planner";
    }
    @PostMapping("/idCheck")
    @ResponseBody
    public Map<String, String> checkid(@RequestBody Map<String, String> requestData) {
        String id = requestData.get("id");
        boolean isDuplicated = plannerService.isIdDuplicated(id);
        if (isDuplicated) {
            return Collections.singletonMap("result", "fail");
        } else {
            return Collections.singletonMap("result", "success");
        }
    }
    @GetMapping("/plannerInfo")
    public  String viewPlanner(){
     return "plannerInfo";
    }


    @GetMapping("/findpw")
    public String findpw(){
        return "findpwplanner";
    }
    @GetMapping("/findid")
    public String findid(){
        return "findidplanner";
    }

    @GetMapping("/logout")
    public String logoutPlanner(){
        return "planner_logout";
    }
    @GetMapping("/logoutYes")
    public String YesLogoutPlanner(HttpSession session){
        session.removeAttribute("planner");
        return"./login";
    }

}


