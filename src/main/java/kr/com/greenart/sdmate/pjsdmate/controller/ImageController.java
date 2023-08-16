package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ImageController {

    @Autowired
    private PlannerService plannerService;
    @Autowired
    private MemberService memberService;

    @PostMapping("/encodeImage")
    public ResponseEntity<Map<String, String>> encodeImage(@RequestBody Map<String, String> payload) throws IOException {
        Map<String, String> response = new HashMap<>();
        System.out.println("여기냐"+payload);
        Planner planner = plannerService.getPlannerByUsername(payload.get("id"));


        String encodedImage = null;
        byte[] image = null;
        try {
            image = planner.getImage();
            encodedImage = Base64.getEncoder().encodeToString(image);
        } catch (NullPointerException e) {
            String imagePath = "static/img/profileDefault.png"; // 클래스패스 내의 이미지 파일 경로
            ClassPathResource resource = new ClassPathResource(imagePath);
            byte[] imageBytes = StreamUtils.copyToByteArray(resource.getInputStream());
            encodedImage = Base64.getEncoder().encodeToString(imageBytes);
        }
        response.put("image", encodedImage);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/encodeImage2")
    public ResponseEntity<Map<String, String>> encodeImage2(@RequestBody Map<String, String> payload) throws IOException {
        Map<String, String> response = new HashMap<>();
        System.out.println("여기냐" + payload);
        System.out.println("여기냐" + payload.get("id"));
        Member member = memberService.getMemberById(payload.get("id"));
        System.out.println("여기냐" + member);
        String encodedImage = null;
        byte[] image = null;
        try {
            image = member.getImage();
            encodedImage = Base64.getEncoder().encodeToString(image);
        } catch (NullPointerException e) {
            String imagePath = "static/img/profileDefault.png"; // 클래스패스 내의 이미지 파일 경로
            ClassPathResource resource = new ClassPathResource(imagePath);
            byte[] imageBytes = StreamUtils.copyToByteArray(resource.getInputStream());
            encodedImage = Base64.getEncoder().encodeToString(imageBytes);
        }

        response.put("image", encodedImage);
        System.out.println("여기냐" + response);
        return ResponseEntity.ok(response);
    }
}
