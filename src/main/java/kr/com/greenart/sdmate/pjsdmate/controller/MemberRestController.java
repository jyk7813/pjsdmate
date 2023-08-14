package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.FindMemberRequest;
import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/findid")
    public ResponseEntity<Member> getMemberById(@RequestBody FindMemberRequest request) {
        Member member = memberService.getMemberById(request.getId());

        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }

    @PostMapping("/findemail")
    public ResponseEntity<Member> getMemberByEmail(@RequestBody FindMemberRequest request) {
        Member member = memberService.getMemberByEmail(request.getEmail());

        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }

}
