package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ImageController {

    @Autowired
    private PlannerService plannerService;

    @PostMapping("/encodeImage")
    public ResponseEntity<Map<String, String>> encodeImage(@RequestBody Map<String, String> payload) {
        Map<String, String> response = new HashMap<>();
        System.out.println("여기냐"+payload);
        Planner planner = plannerService.getPlannerByUsername(payload.get("id"));
        byte[] image = planner.getImage();
        String encodedImage = Base64.getEncoder().encodeToString(image);
        response.put("image", encodedImage);
        return ResponseEntity.ok(response);

    }
}
