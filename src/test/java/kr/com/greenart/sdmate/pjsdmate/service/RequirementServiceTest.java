package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import kr.com.greenart.sdmate.pjsdmate.repository.RequirementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequirementServiceTest {
    @Autowired
    RequirementService requirementService;
    @Autowired
    RequirementRepository requirementRepository;

    @Test
    void 요구사항찾기() {
        Requirement requirement = requirementService.getRequirementByNo(1);
        System.out.print(requirement);
    }
}
