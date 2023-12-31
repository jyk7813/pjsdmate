package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;

import kr.com.greenart.sdmate.pjsdmate.service.MainPageService;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import kr.com.greenart.sdmate.pjsdmate.service.MySpecificationService;
import kr.com.greenart.sdmate.pjsdmate.service.RequirementService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    private final RequirementService requirementService;

    private final MainPageService mainPageService;

    public MemberController(MemberService memberService, RequirementService requirementService, MainPageService mainPageService) {
        this.memberService = memberService;
        this.requirementService = requirementService;
        this.mainPageService = mainPageService;
    }

    @GetMapping("/main")
    public String goMain(Model model,HttpSession session) throws IOException {
        if(session.getAttribute("member")==null){
            return "redirect:./login";
        }
        Member member = (Member) session.getAttribute("member");
        List<mainpageCard> card = mainPageService.returnMainCard(member.getMemberNo());
        int cardSize = card.size();
        String stateString=null;
        if(cardSize==1) {
            stateString = "계약중인 견적서";

            model.addAttribute("plannerNo", card.get(0).getPlannerPk());

        }else if( cardSize == 0){
            stateString = "결혼 축하드립니다.";
        }
        else {
            stateString = "도착한 견적 알림 (" + cardSize + ")";
        }
        if(session.getAttribute("need")!=null){
            session.removeAttribute("need");
        }
        String image = memberService.encoding(member);
        model.addAttribute("image",image);
        model.addAttribute("memberNo", member.getMemberNo());
        model.addAttribute("card", card);
        model.addAttribute("stateString", stateString);
        return "main";
    }
    @GetMapping("/answer")
    public String answer (HttpSession session) {
        if(session.getAttribute("member")==null){
            return "redirect:./login";
        }
        return "answer";
    }

    @GetMapping("/login")
        public String login (HttpSession session) {

        return "login";
        }



    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("member", new Member());
        return "member_join";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public Map<String, String> checkid(@RequestBody Map<String, String> requestData) {
        String id = requestData.get("id");
        boolean isDuplicated = memberService.isIdDuplicated(id);
        if (isDuplicated) {
            return Collections.singletonMap("result", "fail");
        } else {
            return Collections.singletonMap("result", "success");
        }
    }

    @PostMapping("/login")
    public String Login(@RequestParam String id, @RequestParam String pw, @RequestParam String userstat, Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request){

        if(userstat.equals("planner,planner")||userstat.equals("planner")||userstat.equals("member,planner")){
            try {

                request.setAttribute("id",id);
                request.setAttribute("pw",pw);
                request.getRequestDispatcher("/planner/login").forward(request, response);
                return "forward:/planner/login";
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {


            List<String> list = memberService.validate(id, pw);

            //정규식을 검사하고 list 사이즈가 0 이라면
            if (list.isEmpty()) {
                Member member = memberService.Login(id, pw);
                // 돌아온게 널이 아니라면
                if (member != null) {

                    // 자동로그인이 체크 되어 있다면
                    if ((model.getAttribute("AutoLogin")) != null) {

                        // 쿠키 생성하는 행동을 하면 됩니다.
                        Cookie cookie = new Cookie("id", member.getId());
                        response.addCookie(cookie);
                    }

                    session.setAttribute("member", member);
                    //session 시작
                    return "redirect:/member/main";

                } else {
                    list.add("아이디 혹은 비밀번호가 틀렸습니다");
                    model.addAttribute("error", list);

                    return "redirect:/member/login";
                    //null 이라면 아이디가 틀렸거나 비밀번호가 틀렸기 때문에 redirect 를 해줘야합니다

                }
            } else {
                // list 사이즈가 0 이상 이라면 정규식에 벗어난 단어 규칙임으로 페이지로 다시 돌려 보내고 alret 을 띄워야합니다.
                model.addAttribute("error", list);

            }
        }
        // model 객체에 addAttribute 해서 보냄
        return "redirect:/member/login";
    }



    @PostMapping("/join")
    public String join(@Valid @ModelAttribute("member") Member member, BindingResult result, Model model) {
        // 기본적인 Bean Validation 오류 검사
        if (result.hasErrors()) {
            System.out.println("result = " + result);
            return "member_join";
        }
        // 이메일 중복 검사
        if (memberService.isEmailDuplicated(member.getEmail())) {
            result.rejectValue("email", "duplicated", "이미 사용 중인 이메일입니다.");
        }
        // 전화번호 중복 검사
        if (memberService.isPhoneNumDuplicated(member.getPhonenum())) {
            result.rejectValue("phonenum", "duplicated", "이미 사용 중인 전화번호입니다.");
        }
        // ID 중복 검사
        if (memberService.isIdDuplicated(member.getId())) {
            result.rejectValue("id", "duplicated", "이미 사용 중인 ID입니다.");
        }
        // 추가로 발견된 중복 오류가 있는 경우
        if (result.hasErrors()) {

            return "member_join";
        }

        memberService.join(member);
        return "login";
    }
    @PostMapping("/saveq")
    public ResponseEntity<String> RequiremnetSave(@RequestBody Requirement requirement, HttpSession session){

        Member member = (Member) session.getAttribute("member");
        requirementService.insertRequirement(requirement,member.getMemberNo());
        return ResponseEntity.ok("데이터가 성공적으로 저장되었습니다.");
    }
    @GetMapping("/findpw")
    public String findpw(){
        return "findpwmember";
    }
    @GetMapping("/findid")
    public String findid(){
        return "findidmember";
    }
    @GetMapping("/logout")
    public String logOut(){
        return "member_logout";
    }
    @GetMapping("/logoutYes")
    public String logOut(HttpSession session){
        session.removeAttribute("member");
        return "./login";
    }

    @PostMapping("/updataImage")
    public ResponseEntity<String> updataImage(@RequestParam("image") MultipartFile file, HttpSession session) throws IOException {
        Member member = (Member) session.getAttribute("member");
        byte[] image = file.getBytes();
        System.out.println("야!!!!!!!!!!!!!!!!!" + image);
        memberService.updataImage(image,member.getMemberNo());
        return ResponseEntity.ok("성공됐습니다");
    }
}
