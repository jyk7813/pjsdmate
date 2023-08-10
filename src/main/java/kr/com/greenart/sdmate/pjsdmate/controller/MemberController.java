package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;

import kr.com.greenart.sdmate.pjsdmate.service.MainPageService;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    private final MainPageService mainPageService;

    public MemberController(MemberService memberService, MainPageService mainPageService) {
        this.memberService = memberService;
        this.mainPageService = mainPageService;
    }

    @GetMapping("/main")
    public String goMain(Model model,HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        System.out.println(member);
        List<mainpageCard> card = mainPageService.returnMainCard(member.getMemberNo());


        model.addAttribute("card", card);
//
//        @GetMapping("/")
//        public String start () {
//            return "start";
//        }
//        @GetMapping("/main")
//        public String main () {
//            return "main";
//        }
        return "main";

    }

    @GetMapping("/login")
        public String login () {
            return "login";
        }

    @GetMapping("/answer")
    public String answer () {
        return "answer";
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
        if(userstat.equals("planner,planner")||userstat.equals("planner")){
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


//    public String searchId(Model model){
//        // 값 꺼내오기
//        String name = (String)model.getAttribute("id");
//        String birth = (String) model.getAttribute("birth");
//        // 출력될 문장
//        String searchId = memberService.searchId(name, birth);
//        model.addAttribute("searchId",searchId);
//        return "Login";
//    }
//    public String searchPass(Model model){
//        //값꺼내오기
//        String name = (String)model.getAttribute("name");
//        String birth = (String)model.getAttribute("birth");
//        String id = (String)model.getAttribute("id");
//
//        String searchPass = memberService.searchPassWord(name,birth,id);
//        model.addAttribute("searchPass",searchPass);
//        return "Login";
//    }

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

}
