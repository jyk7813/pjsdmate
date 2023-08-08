package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlannerServiceTest {
    @Autowired
    PlannerService plannerService;
    @Autowired
    PlannerRepository plannerRepository;

    @Test
    void 플래너찾기() {
        Planner planner = plannerService.getPlannerById(1);
        System.out.print(planner);
    }
}
