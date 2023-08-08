package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpecificationServiceTest {
    @Autowired
    SpecificationService specificationService;
    @Autowired
    SpecificationRepository specificationRepository;

    @Test
    void 견적서찾기() {
        Specification specification = specificationService.getSpecificationByNo(1);
        System.out.print(specification);

    }
}
