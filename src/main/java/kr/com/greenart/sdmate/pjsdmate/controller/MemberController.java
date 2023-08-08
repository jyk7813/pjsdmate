package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import kr.com.greenart.sdmate.pjsdmate.service.ValidatorMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/")
    public String start(){
        return "start";
    }

    @GetMapping("/main")
    public String main() {


        return "main";
    }


    // 로그인 매핑을 해주세요
    public String Login(Model model, HttpSession session, HttpServletResponse response){

        String id =(String)model.getAttribute("id");
        String pass =(String)model.getAttribute("password");

        List<String> list =memberService.validate(id,pass);

        //정규식을 검사하고 list 사이즈가 0 이라면
        if(list.size() ==0) {
            Integer userPk = memberService.Login(id, pass);
            // 돌아온게 널이 아니라면
            if (userPk != null) {

                // 자동로그인이 체크 되어 있다면
                if ((model.getAttribute("AutoLogin")) != null) {

                    // 쿠키 생성하는 행동을 하면 됩니다.
                    Cookie cookie = new Cookie("username", "john");
                    response.addCookie(cookie);
                }

                //session 시작
                session.setAttribute("userPk", userPk);
            } else {
                list.add("아이디 혹은 비밀번호가 틀렸습니다");
                model.addAttribute("error",list);
                //null 이라면 아이디가 틀렸거나 비밀번호가 틀렸기 때문에 redirect 를 해줘야합니다

            }
        }else{
            // list 사이즈가 0 이상 이라면 정규식에 벗어난 단어 규칙임으로 페이지로 다시 돌려 보내고 alret 을 띄워야합니다.
            model.addAttribute("error",list);

        }
            // model 객체에 addAttribute 해서 보냄
        return "리턴될 페이지 적어주시면 됩니다.";
    }


    @GetMapping("/answer")
    public String answer() {
        return "answer";
    }


    @GetMapping("/member/join")
    public String join() { return "member_join"; }

}

