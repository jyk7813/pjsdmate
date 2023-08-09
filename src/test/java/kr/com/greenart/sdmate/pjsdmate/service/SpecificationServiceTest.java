package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void 견적서리스트찾기() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Specification> list = new ArrayList<>();
        for(int i=0;i<a.size();i++) {
            list.add(specificationService.getSpecificationByNo(a.get(i)));
        }

        System.out.print(list);

    }
}
