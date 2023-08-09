package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.mainpageCard;

import kr.com.greenart.sdmate.pjsdmate.service.MainPageService;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.ArrayList;
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
    public String main(Model model) {

        List<mainpageCard> card = mainPageService.returnMainCard(1);


        model.addAttribute("card", card);
//        @GetMapping("/answer")
//        public String answer () {
//            return "answer";
//        }
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

    @GetMapping("/mainplanner")
    public String mainplanner() {
        return "mainplanner";
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
    public String Login(@RequestParam String id, @RequestParam String pw,Model model, HttpSession session, HttpServletResponse response) {


        List<String> list = memberService.validate(id, pw);

        //정규식을 검사하고 list 사이즈가 0 이라면
        if (list.size() == 0) {
            Member member = memberService.Login(id, pw);
            // 돌아온게 널이 아니라면
            if (member != null) {

                // 자동로그인이 체크 되어 있다면
                if ((model.getAttribute("AutoLogin")) != null) {

                    // 쿠키 생성하는 행동을 하면 됩니다.
                    Cookie cookie = new Cookie("username", "john");
                    response.addCookie(cookie);
                }

                session.setAttribute("member", member);
                model.addAttribute("member", member);
                //session 시작


                return "redirect:/member/main";
            } else {
                list.add("아이디 혹은 비밀번호가 틀렸습니다");
                model.addAttribute("error", list);

                //null 이라면 아이디가 틀렸거나 비밀번호가 틀렸기 때문에 redirect 를 해줘야합니다

            }
        } else {
            // list 사이즈가 0 이상 이라면 정규식에 벗어난 단어 규칙임으로 페이지로 다시 돌려 보내고 alret 을 띄워야합니다.
            model.addAttribute("error", list);

        }

        // model 객체에 addAttribute 해서 보냄
        return "/login";
    }


    public String searchId(Model model){
        // 값 꺼내오기
        String name = (String)model.getAttribute("id");
        String birth = (String) model.getAttribute("birth");
        // 출력될 문장
        String searchId = memberService.searchId(name, birth);
        model.addAttribute("searchId",searchId);
        return "Login";
    }
    public String searchPass(Model model){
        //값꺼내오기
        String name = (String)model.getAttribute("name");
        String birth = (String)model.getAttribute("birth");
        String id = (String)model.getAttribute("id");

        String searchPass = memberService.searchPassWord(name,birth,id);
        model.addAttribute("searchPass",searchPass);
        return "Login";
    }

//    @PostMapping ("/join")
//    public String join(Model model) {
//        //요청에 member 를 String 으로 받아옴
//        String json = (String)model.getAttribute("member");
//        //json 을 memberservice 에서 적합성을 검사하고  에러가 있다면
//        // list 에 담겨 져서 옴
//        List<String> list = memberService.validate(json);
//        //list size가 0 이라는 것은 적합성 검사를 전부 통과 했다는 말이기 떄문에
//        //에러가 없는 것임으로 회원가입을 진행
//        if(list.size()==0){
//            model.addAttribute("success","회원 가입에 성공 했습니다");
//            memberService.join(json);
//            return "redirect:/member/login";
//        }else{
//            //list 사이즈가 0 이 아니라면 적합성 검사를 통과하지못했기 때문에
//            // db 에 넣지 않고 에러를 담은 list 만 반환.
//            model.addAttribute("error",list);
//            // 그리고 if 문을 빠져나가서 회원 가입 창으로 다시 돌아옴.
//        }
//
//        return "redirect:/member/join";
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
