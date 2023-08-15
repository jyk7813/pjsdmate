package kr.com.greenart.sdmate.pjsdmate.controller;

import kr.com.greenart.sdmate.pjsdmate.domain.FindPlannerRequest;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.service.PlannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planner")
public class PlannerRestController {

    private final PlannerService plannerService;

    public PlannerRestController(PlannerService plannerService) {
        this.plannerService = plannerService;
    }

    @PostMapping("/findid")
    public ResponseEntity<Planner> getPlannerById(@RequestBody FindPlannerRequest request) {
        Planner planner = plannerService.getPlannerByUsername(request.getId());

        if (planner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(planner);
    }

    @PostMapping("/findemail")
    public ResponseEntity<Planner> getPlannerByEmail(@RequestBody FindPlannerRequest request) {
        Planner planner = plannerService.getPlannerByEmail(request.getEmail());

        if (planner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(planner);
    }

}
